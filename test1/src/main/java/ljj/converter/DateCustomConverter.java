package ljj.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;

public class DateCustomConverter implements Converter<String, Date> {

	private Log logger =  LogFactory.getLog(DateCustomConverter.class);
	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(source);
			return date;
		} catch (ParseException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

}
