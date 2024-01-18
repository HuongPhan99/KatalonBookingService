import org.apache.commons.lang.RandomStringUtils
import com.kms.katalon.core.annotation.Keyword
public class commonKeyWords {

	/**
	 * Generate unique string
	 * @return unique string with special length
	 */
	@Keyword
	def generateRandomKey(int length) {
		String charset = (('a'..'z') ).join()
		String randomString = RandomStringUtils.random(length, charset.toCharArray())
		return randomString.toLowerCase().capitalize();
	}
}
