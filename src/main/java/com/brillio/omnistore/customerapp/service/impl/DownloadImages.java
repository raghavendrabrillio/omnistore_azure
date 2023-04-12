package com.brillio.omnistore.customerapp.service.impl;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;

public class DownloadImages {
	public static void main(String[] args) throws Exception {

		Map<String, String> myMap = new HashMap<String, String>() {

			private static final long serialVersionUID = 1L;

			{
				put("HT-2001_Lime-1149-XL", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_Mint-1450-M", "https://images-na.ssl-images-amazon.com/images/I/41ygbhq127L.jpg");
				put("HT-2001_Red-1156-XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Lapis-1156-2XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Lapis-1156-M", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Mint-1450-L", "https://images-na.ssl-images-amazon.com/images/I/41ygbhq127L.jpg");
				put("HT-2001_Turquoise-1156-XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Mint-1450-S", "https://images-na.ssl-images-amazon.com/images/I/41ygbhq127L.jpg");
				put("HT-2001_LightAqua-1149-2XL", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_Red-1156-2XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_LightBlue-1149-M", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_Raspberry-1156-L", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Red-1156-S", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Mint-1442-L", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Mauve-1442-L", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_KellyGreen-1149-L", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_Lemon-1149-M", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_Mint-1450-2XL", "https://images-na.ssl-images-amazon.com/images/I/41ygbhq127L.jpg");
				put("HT-2001_Lime-1442-XL", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Mauve-1442-M", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Mauve-1442-2XL", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Lime-1442-S", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Slate-1156-M", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Fuchsia-1156-L", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Lime-1442-L", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Fuchsia-1156-2XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_LightAqua-1149-S", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_KellyGreen-1156-S", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Raspberry-1156-M", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Mint-1450-XL", "https://images-na.ssl-images-amazon.com/images/I/41ygbhq127L.jpg");
				put("HT-2001_Slate-1156-S", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Raspberry-1156-XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_RoyalBlue-1156-XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_RoyalBlue-1156-2XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Lime-1149-S", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_NewSilver-1450-2XL", "https://images-na.ssl-images-amazon.com/images/I/41ygbhq127L.jpg");
				put("HT-2001_HeatherGrey-1450-S", "https://images-na.ssl-images-amazon.com/images/I/41ygbhq127L.jpg");
				put("HT-2001_LightPink-1149-L", "https://images-na.ssl-images-amazon.com/images/I/41dCf%2BplpCL.jpg");
				put("HT-2001_Lime-1442-M", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Mauve-1442-XL", "https://images-na.ssl-images-amazon.com/images/I/411%2BJEmxT-L.jpg");
				put("HT-2001_Turquoise-1156-S", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("HT-2001_Lapis-1156-XL", "https://images-na.ssl-images-amazon.com/images/I/41-qQ6WiqyL.jpg");
				put("SS_54079-Navy-M", "https://images-na.ssl-images-amazon.com/images/I/415uHf1EfBL.jpg");
				put("56504000409", "https://images-na.ssl-images-amazon.com/images/I/41Z-KBHgD1L.jpg");
				put("56447516906", "https://images-na.ssl-images-amazon.com/images/I/41VmCPlcW5L.jpg");
				put("56504000406", "https://images-na.ssl-images-amazon.com/images/I/41Z-KBHgD1L.jpg");
				put("56504000508", "https://images-na.ssl-images-amazon.com/images/I/41-Y9n0GovL.jpg");
				put("56504000510", "https://images-na.ssl-images-amazon.com/images/I/41-Y9n0GovL.jpg");
				put("56504000405", "https://images-na.ssl-images-amazon.com/images/I/41Z-KBHgD1L.jpg");
				put("577F_BLK_23XXL", "https://images-na.ssl-images-amazon.com/images/I/31ZP7mh1ALL.jpg");
				put("56504017010", "https://images-na.ssl-images-amazon.com/images/I/41bnVjVW%2BNL.jpg");
				put("56504001909", "https://images-na.ssl-images-amazon.com/images/I/41b6U2NGABL.jpg");
				put("56504017110", "https://images-na.ssl-images-amazon.com/images/I/41n9ek90QAL.jpg");
				put("BZS402090739F1003", "https://images-na.ssl-images-amazon.com/images/I/41S7B87lLmL.jpg");
				put("Kaf-App-78", "https://images-na.ssl-images-amazon.com/images/I/31yYuSp10dL.jpg");
				put("BZS40209073103001", "https://images-na.ssl-images-amazon.com/images/I/41uXkpEGEnL.jpg");
				put("BZS40188912232002", "https://images-na.ssl-images-amazon.com/images/I/41gNKjsSTeL.jpg");
				put("BZS40188912232001", "https://images-na.ssl-images-amazon.com/images/I/41gNKjsSTeL.jpg");
				put("56504000809", "https://images-na.ssl-images-amazon.com/images/I/41x1G5Orx4L.jpg");
				put("56504017009", "https://images-na.ssl-images-amazon.com/images/I/41bnVjVW%2BNL.jpg");
				put("BZS402090719F0002", "https://images-na.ssl-images-amazon.com/images/I/418BeZNDq2L.jpg");
				put("BZS402090739J6001", "https://images-na.ssl-images-amazon.com/images/I/41y-ZTZmPhL.jpg");
				put("56504009409", "https://images-na.ssl-images-amazon.com/images/I/414uN0GaJJL.jpg");
				put("BZS40209073103003", "https://images-na.ssl-images-amazon.com/images/I/41GssoOcnVL.jpg");
				put("BZS40188912CT7003", "https://images-na.ssl-images-amazon.com/images/I/41bBk8QXrSL.jpg");
				put("BZS401889122E4002", "https://images-na.ssl-images-amazon.com/images/I/41-PRZM0opL.jpg");
				put("56470000407", "https://images-na.ssl-images-amazon.com/images/I/31D7jrr7VsL.jpg");
				put("BZS402090689N5002", "https://images-na.ssl-images-amazon.com/images/I/51JDSG2WTIL.jpg");
				put("BZS40188912232003", "https://images-na.ssl-images-amazon.com/images/I/41gNKjsSTeL.jpg");
				put("BZS40188912100002", "https://images-na.ssl-images-amazon.com/images/I/41hX9KUIT1L.jpg");
				put("56504009408", "https://images-na.ssl-images-amazon.com/images/I/414uN0GaJJL.jpg");
				put("56504017104", "https://images-na.ssl-images-amazon.com/images/I/41n9ek90QAL.jpg");
				put("56504017008", "https://images-na.ssl-images-amazon.com/images/I/41bnVjVW%2BNL.jpg");
				put("56504001904", "https://images-na.ssl-images-amazon.com/images/I/41b6U2NGABL.jpg");
				put("56504000610", "https://images-na.ssl-images-amazon.com/images/I/413Qrr3sxvL.jpg");
				put("569F_SKY_7S", "https://images-na.ssl-images-amazon.com/images/I/31iSQyCQmVL.jpg");
				put("56504000810", "https://images-na.ssl-images-amazon.com/images/I/41x1G5Orx4L.jpg");
				put("56504016610", "https://images-na.ssl-images-amazon.com/images/I/31V%2BTQA07VL.jpg");
				put("56467500107", "https://images-na.ssl-images-amazon.com/images/I/41mKOmsVLHL.jpg");
				put("56447529507", "https://images-na.ssl-images-amazon.com/images/I/41pBr3qE9iL.jpg");
				put("56447517104", "https://images-na.ssl-images-amazon.com/images/I/413mXGMDHlL.jpg");
				put("56504017105", "https://images-na.ssl-images-amazon.com/images/I/41n9ek90QAL.jpg");
				put("BZS401889122E4003", "https://images-na.ssl-images-amazon.com/images/I/41-PRZM0opL.jpg");
				put("56469500406", "https://images-na.ssl-images-amazon.com/images/I/413Wxxk1jTL.jpg");
				put("56504017109", "https://images-na.ssl-images-amazon.com/images/I/41n9ek90QAL.jpg");
				put("DI-1254-20--LB", "https://images-na.ssl-images-amazon.com/images/I/415QSuxqCsL.jpg");
				put("B00RDED2VABright WhiteM", "https://images-na.ssl-images-amazon.com/images/I/31dzQEQQqpL.jpg");
				put("8414-33-M", "https://images-na.ssl-images-amazon.com/images/I/41N5rDYyYRL.jpg");
				put("15260651606_A_34 (P)", "https://images-na.ssl-images-amazon.com/images/I/51J9QcXgphL.jpg");
				put("LA4-3665-XL-Green Woodland", "https://images-na.ssl-images-amazon.com/images/I/41rYt3F%2BywL.jpg");
				put("55288001207", "https://images-na.ssl-images-amazon.com/images/I/31UWyoak3UL.jpg");
				put("8530-14-2XL", "https://images-na.ssl-images-amazon.com/images/I/419BTzohmDL.jpg");
				put("DI-1254-14--LB", "https://images-na.ssl-images-amazon.com/images/I/415QSuxqCsL.jpg");
				put("HT-2001_Mint-1440-XL", "https://images-na.ssl-images-amazon.com/images/I/41p13Z9O9HL.jpg");
				put("D440W-XL-NEW BUTTER", "https://images-na.ssl-images-amazon.com/images/I/21dnUU4tBvL.jpg");
				put("AL-M315W-Red-S", "https://images-na.ssl-images-amazon.com/images/I/31mdAJWDy4L.jpg");
				put("HT-2001_Cranberry-1167-XL", "https://images-na.ssl-images-amazon.com/images/I/51ZtwWcXuEL.jpg");
				put("VVXXCQ9_Biscuit_S",
						"https://images-na.ssl-images-amazon.com/images/I/41bcOzmu4-L.jpg");
				put("3333-41-2XL", "https://images-na.ssl-images-amazon.com/images/I/41gnbDKnBSL.jpg");
				put("B00RDED314Bright WhiteL", "https://images-na.ssl-images-amazon.com/images/I/31dzQEQQqpL.jpg");
				put("141030747", "https://images-na.ssl-images-amazon.com/images/I/41fTtpvmG2L.jpg");
				put("HT-2001_BabyBlue-1167-2XL", "https://images-na.ssl-images-amazon.com/images/I/51ZtwWcXuEL.jpg");
				put("55287001206", "https://images-na.ssl-images-amazon.com/images/I/41hUjkjUDYL.jpg");
				put("B02768113", "https://images-na.ssl-images-amazon.com/images/I/31efFata4rL.jpg");
				put("HT-2001_Creme-1167-XL", "https://images-na.ssl-images-amazon.com/images/I/51ZtwWcXuEL.jpg");
				put("DI-FS010-XL--WH", "https://images-na.ssl-images-amazon.com/images/I/41guqL8Hp0L.jpg");
				put("1D31N_____XS-BLK", "https://images-na.ssl-images-amazon.com/images/I/41UmkoW8lYL.jpg");
				put("T0A1JV_054-S", "https://images-na.ssl-images-amazon.com/images/I/41W-CfvhzzL.jpg");
				put("B00RDECZUEBright WhiteS", "https://images-na.ssl-images-amazon.com/images/I/31dzQEQQqpL.jpg");
				put("KA4927-N57_12 (M)", "https://images-na.ssl-images-amazon.com/images/I/41ckg377%2BTL.jpg");
				put("SS471_WHI_7S", "https://images-na.ssl-images-amazon.com/images/I/31AvvpGZ-OL.jpg");
				put("SS481_RED_15L", "https://images-na.ssl-images-amazon.com/images/I/31t7UHH7ZsL.jpg");
				put("SS481_WHI_7S", "https://images-na.ssl-images-amazon.com/images/I/317-NbHW7SL.jpg");
				put("SS481_BLK_11M", "https://images-na.ssl-images-amazon.com/images/I/31siWh%2B2b2L.jpg");
				put("B01A6W0RP4Rot 36", "https://images-na.ssl-images-amazon.com/images/I/410k5FiXcCL.jpg");
				put("SS481_RED_23XXL", "https://images-na.ssl-images-amazon.com/images/I/31VbZjz4OJL.jpg");
				put("SS481_WHI_23XXL", "https://images-na.ssl-images-amazon.com/images/I/317-NbHW7SL.jpg");
				put("KA4927-N57_8 (X-Small)", "https://images-na.ssl-images-amazon.com/images/I/41ckg377%2BTL.jpg");
				put("SS481_MBL_11M", "https://images-na.ssl-images-amazon.com/images/I/4182DSxUkSL.jpg");
				put("SS481_WHI_15L", "https://images-na.ssl-images-amazon.com/images/I/317-NbHW7SL.jpg");
				put("SS481_MBL_7S", "https://images-na.ssl-images-amazon.com/images/I/4182DSxUkSL.jpg");
				put("GA-101500-8341", "https://images-na.ssl-images-amazon.com/images/I/31mpzmLzwyL.jpg");
				put("KA4927-N57_10 (Small)", "https://images-na.ssl-images-amazon.com/images/I/41ckg377%2BTL.jpg");
				put("SS481_NAV_15L", "https://images-na.ssl-images-amazon.com/images/I/31yT5TCJTFL.jpg");

			}
		};

		for (Map.Entry<String, String> entry : myMap.entrySet()) {
			String FILE_URL = entry.getValue();
			String FILE_NAME = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\images\\" + entry.getKey() + ".jpg";
			System.out.println(FILE_NAME + " : " + FILE_URL);
			URL website = new URL(FILE_URL);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(FILE_NAME);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		}
	}

}
