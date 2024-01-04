package DataProviders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ExpectedValues {
	
	public static final List<String> assetTypes =Arrays.asList("AVOD","TVOD","SVOD");
	public static final List<String> countryRights=Arrays.asList("AE", "SA", "TN", "KW", "QA", "OM", "BH", "DZ", "IQ", "JO", "LB", "MA", "DJ", "LY", "PS", "MR", "YE", "IE", "DE", "FR", "EG", "SD", "SS", "US","KR");
    public static final List<String> contentOwnership=Arrays.asList("evision","starz");
    public static final List<Integer> programTypes=Arrays.asList(0,1);

    public static final List<Integer> ageRating =Arrays.asList(7,15,18,1);
    public static final List<String> subscription=Arrays.asList("starzplaysports","criclife","adsports","seriea","ufc","starz","rwc","coppaitalia","blutv","discovery","nba","davinci","watchit");


}
