import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties

fun main() {
    val dataModel1 = DataModel1(
        platform = "Android",
        appTeamId = "android.valensas.team",
        appConfig = "DEBUG",
        appVersion = "1.0.9",
        deviceUniqueIdentifier = "fb963679a02ceb27",
        userInfo = DataModel2(
            name = "Batuhan",
            surname = "Simsek",
            password = "1234"
        )
    )

    println(dataModel1.toString())

    println(workWithStr(dataModel1.toString()))

    //println(workWithObj(anyClass = dataModel1))
}

fun workWithObj(anyClass: Any) : String{
    var result = ""
    anyClass::class.declaredMemberProperties.forEach { type ->
        val pattern = "platform|appConfig|userInfo".toRegex()
        val value = anyClass.getField<Any>(type.name).toString()
        result = if (pattern.matches(type.name)) {
            "$result${type.name}=${value.replace("[\\w+]".toRegex(), "*")}, "
        } else {
            "$result${type.name}=${value}, "
        }
    }
    return result
}

@Suppress("UNCHECKED_CAST")
fun <R> readInstanceProperty(instance: Any, propertyName: String): R {
    val property = instance::class.memberProperties
        .first { it.name == propertyName } as KProperty1<Any, *>
    return property.get(instance) as R
}

@Throws(IllegalAccessException::class, ClassCastException::class)
inline fun <reified T> Any.getField(fieldName: String): T? {
    this::class.memberProperties.forEach { kCallable ->
        if (fieldName == kCallable.name) {
            return kCallable.getter.call(this) as T?
        }
    }
    return null
}

data class DataModel1(
    val platform: String,
    val appTeamId: String,
    val appConfig: String,
    val appVersion: String,
    val deviceUniqueIdentifier: String,
    val userInfo: DataModel2? = null
)

data class DataModel2(
    val name: String,
    val surname: String,
    val password: String
)

fun workWithStr(modelStr: String): String {
    //val patternSensitiveData = "(.+)?(password)=(\\w+|.+)?".toRegex()
    val patternSensitiveData = createPattern(logSensitiveData = LogSensitiveData())

    val result = arrayListOf<String>()

    modelStr.split(",").forEachIndexed { index, s ->
        if (patternSensitiveData.matches(s)) {
            val matchResult = patternSensitiveData.find(s)
            val replacementString  = matchResult?.groupValues?.get(3)?.replace("[\\w+]".toRegex(), "*") ?: ""
            result.add(patternSensitiveData.find(s)?.let { it.value.replace(it.groupValues[3], replacementString) }.toString())
        } else {
            result.add(s)
        }
    }
    
    return result.joinToString(", ")
}

private fun createPattern(logSensitiveData : LogSensitiveData): Regex {
    var result = ""
    logSensitiveData.sensitiveParams.forEachIndexed { index, s ->
        result = if (index == logSensitiveData.sensitiveParams.lastIndex) {
            "$result$s"
        } else {
            "$result$s|"
        }
    }

    return "(.+)?($result)=(\\w+|.+)?".toRegex()
}

data class LogSensitiveData (
    var sensitiveParams: List<String> = listOf("platform","appConfig","surname")
)