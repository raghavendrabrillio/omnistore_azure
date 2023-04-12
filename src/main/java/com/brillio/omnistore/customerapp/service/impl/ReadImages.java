package com.brillio.omnistore.customerapp.service.impl;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadImages {

	public static void main(String[] args) {
		System.out.println(getFiles());
	}

	public static Map<String, String> getFiles() {
		Set<String> list = new TreeSet<>();
		list.add(
				"11,'FeatherLite Ladies Moisture Free Mesh Sport ShirtWhite XXX-Large',1,20.54,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lime-1149-XL.jpg'),'raghu',now(),'HT-2001_Lime-1149-XL','XL'");
		list.add(
				"12,'FeatherLite Ladies Long Sleeve Stain Resistant Tapered Twill ShirtPacific B.',1,22.78,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mint-1450-M.jpg'),'raghu',now(),'HT-2001_Mint-1450-M','M'");
		list.add(
				"13,'FeatherLite Ladies Pique Sport ShirtRed Medium',1,14.97,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Red-1156-XL.jpg'),'raghu',now(),'HT-2001_Red-1156-XL','XL'");
		list.add(
				"14,'FeatherLite Ladies Pique Sport ShirtForest Green XX-Large',1,16.7,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lapis-1156-2XL.jpg'),'raghu',now(),'HT-2001_Lapis-1156-2XL','XXL'");
		list.add(
				"15,'FeatherLite Ladies Pique Sport ShirtForest Green Medium',1,14.97,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lapis-1156-M.jpg'),'raghu',now(),'HT-2001_Lapis-1156-M','M'");
		list.add(
				"16,'FeatherLite Ladies Long Sleeve Stain Resistant Tapered Twill ShirtPacific B.',1,22.91,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mint-1450-L.jpg'),'raghu',now(),'HT-2001_Mint-1450-L','L'");
		list.add(
				"17,'FeatherLite Ladies Pique Sport ShirtWhite X-Large',1,15.1,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Turquoise-1156-XL.jpg'),'raghu',now(),'HT-2001_Turquoise-1156-XL','XL'");
		list.add(
				"18,'FeatherLite Ladies Long Sleeve Stain Resistant Tapered Twill ShirtPacific B.',1,22.78,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mint-1450-S.jpg'),'raghu',now(),'HT-2001_Mint-1450-S','S'");
		list.add(
				"19,'FeatherLite Ladies Moisture Free Mesh Sport ShirtRed X-Large',1,27.16,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_LightAqua-1149-2XL.jpg'),'raghu',now(),'HT-2001_LightAqua-1149-2XL','XXL'");
		list.add(
				"20,'FeatherLite Ladies Pique Sport ShirtRed Large',1,14.97,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Red-1156-2XL.jpg'),'raghu',now(),'HT-2001_Red-1156-2XL','XXL'");
		list.add(
				"21,'FeatherLite Ladies Moisture Free Mesh Sport ShirtRed XXX-Large',1,20.54,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_LightBlue-1149-M.jpg'),'raghu',now(),'HT-2001_LightBlue-1149-M','M'");
		list.add(
				"22,'FeatherLite Ladies Pique Sport ShirtNavy Medium',1,14.97,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Raspberry-1156-L.jpg'),'raghu',now(),'HT-2001_Raspberry-1156-L','L'");
		list.add(
				"23,'FeatherLite Ladies Pique Sport ShirtNavy XX-Large',1,16.7,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Red-1156-S.jpg'),'raghu',now(),'HT-2001_Red-1156-S','S'");
		list.add(
				"24,'FeatherLite Ladies Long Sleeve Oxford ShirtWhite Small',1,21.65,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mint-1442-L.jpg'),'raghu',now(),'HT-2001_Mint-1442-L','L'");
		list.add(
				"25,'FeatherLite Ladies Long Sleeve Oxford ShirtLight Blue Medium',1,21.78,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mauve-1442-L.jpg'),'raghu',now(),'HT-2001_Mauve-1442-L','L'");
		list.add(
				"26,'FeatherLite Ladies Moisture Free Mesh Sport ShirtBlack X-Large',1,27.16,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_KellyGreen-1149-L.jpg'),'raghu',now(),'HT-2001_KellyGreen-1149-L','L'");
		list.add(
				"27,'FeatherLite Ladies Moisture Free Mesh Sport ShirtNavy Medium',1,26.83,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lemon-1149-M.jpg'),'raghu',now(),'HT-2001_Lemon-1149-M','M'");
		list.add(
				"28,'FeatherLite Ladies Long Sleeve Stain Resistant Tapered Twill ShirtPacific B.',1,26.45,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mint-1450-2XL.jpg'),'raghu',now(),'HT-2001_Mint-1450-2XL','XXL'");
		list.add(
				"29,'FeatherLite Ladies Long Sleeve Oxford ShirtFrench Blue X-Large',1,21.84,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lime-1442-XL.jpg'),'raghu',now(),'HT-2001_Lime-1442-XL','XL'");
		list.add(
				"30,'FeatherLite Ladies Long Sleeve Oxford ShirtLight Blue Small',1,21.65,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mauve-1442-M.jpg'),'raghu',now(),'HT-2001_Mauve-1442-M','M'");
		list.add(
				"31,'FeatherLite Ladies Long Sleeve Oxford ShirtLight Blue X-Large',1,21.82,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mauve-1442-2XL.jpg'),'raghu',now(),'HT-2001_Mauve-1442-2XL','XXL'");
		list.add(
				"32,'FeatherLite Ladies Long Sleeve Oxford ShirtFrench Blue Small',1,21.65,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lime-1442-S.jpg'),'raghu',now(),'HT-2001_Lime-1442-S','S'");
		list.add(
				"33,'FeatherLite Ladies Pique Sport ShirtRoyal X-Large',1,15.1,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Slate-1156-M.jpg'),'raghu',now(),'HT-2001_Slate-1156-M','M'");
		list.add(
				"34,'FeatherLite Ladies Pique Sport ShirtBlack Small',1,14.97,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Fuchsia-1156-L.jpg'),'raghu',now(),'HT-2001_Fuchsia-1156-L','L'");
		list.add(
				"35,'FeatherLite Ladies Long Sleeve Oxford ShirtFrench Blue Large',1,21.78,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lime-1442-L.jpg'),'raghu',now(),'HT-2001_Lime-1442-L','L'");
		list.add(
				"36,'FeatherLite Ladies Pique Sport ShirtBlack Large',1,21.67,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Fuchsia-1156-2XL.jpg'),'raghu',now(),'HT-2001_Fuchsia-1156-2XL','XXL'");
		list.add(
				"37,'FeatherLite Ladies Moisture Free Mesh Sport ShirtNavy XXX-Large',1,20.54,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_LightAqua-1149-S.jpg'),'raghu',now(),'HT-2001_LightAqua-1149-S','S'");
		list.add(
				"38,'FeatherLite Ladies Pique Sport ShirtCool Grey Medium',1,21.67,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_KellyGreen-1156-S.jpg'),'raghu',now(),'HT-2001_KellyGreen-1156-S','S'");
		list.add(
				"39,'FeatherLite Ladies Pique Sport ShirtNavy Small',1,140.89,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Raspberry-1156-M.jpg'),'raghu',now(),'HT-2001_Raspberry-1156-M','M'");
		list.add(
				"40,'FeatherLite Ladies Long Sleeve Stain Resistant Tapered Twill ShirtPacific B.',1,58.5,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mint-1450-XL.jpg'),'raghu',now(),'HT-2001_Mint-1450-XL','XL'");
		list.add(
				"41,'FeatherLite Ladies Pique Sport ShirtRoyal Large',1,19.99,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Slate-1156-S.jpg'),'raghu',now(),'HT-2001_Slate-1156-S','S'");
		list.add(
				"42,'FeatherLite Ladies Pique Sport ShirtNavy Large',1,11.99,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Raspberry-1156-XL.jpg'),'raghu',now(),'HT-2001_Raspberry-1156-XL','XL'");
		list.add(
				"43,'FeatherLite Ladies Pique Sport ShirtRoyal Small',1,61.6,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_RoyalBlue-1156-XL.jpg'),'raghu',now(),'HT-2001_RoyalBlue-1156-XL','XL'");
		list.add(
				"44,'FeatherLite Ladies Pique Sport ShirtRoyal Medium',1,27.16,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_RoyalBlue-1156-2XL.jpg'),'raghu',now(),'HT-2001_RoyalBlue-1156-2XL','XXL'");
		list.add(
				"45,'FeatherLite Ladies Moisture Free Mesh Sport ShirtWhite Large',1,100,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lime-1149-S.jpg'),'raghu',now(),'HT-2001_Lime-1149-S','S'");
		list.add(
				"46,'FeatherLite Ladies Long Sleeve Stain Resistant Tapered Twill ShirtSandalwoo.',1,9,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_NewSilver-1450-2XL.jpg'),'raghu',now(),'HT-2001_NewSilver-1450-2XL','XXL'");
		list.add(
				"47,'FeatherLite Ladies Long Sleeve Stain Resistant Tapered Twill ShirtAmerican .',1,18.69,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_HeatherGrey-1450-S.jpg'),'raghu',now(),'HT-2001_HeatherGrey-1450-S','S'");
		list.add(
				"48,'FeatherLite Ladies Moisture Free Mesh Sport ShirtRoyal XXX-Large',1,39.8,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_LightPink-1149-L.jpg'),'raghu',now(),'HT-2001_LightPink-1149-L','L'");
		list.add(
				"49,'FeatherLite Ladies Long Sleeve Oxford ShirtFrench Blue Medium',1,7.9,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lime-1442-M.jpg'),'raghu',now(),'HT-2001_Lime-1442-M','M'");
		list.add(
				"50,'FeatherLite Ladies Long Sleeve Oxford ShirtLight Blue Large',1,79.2,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mauve-1442-XL.jpg'),'raghu',now(),'HT-2001_Mauve-1442-XL','XL'");
		list.add(
				"51,'FeatherLite Ladies Pique Sport ShirtWhite Small',1,94,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Turquoise-1156-S.jpg'),'raghu',now(),'HT-2001_Turquoise-1156-S','S'");
		list.add(
				"52,'FeatherLite Ladies Pique Sport ShirtForest Green X-Large',1,15.1,'Shirt','FeatherLite',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Lapis-1156-XL.jpg'),'raghu',now(),'HT-2001_Lapis-1156-XL','XL'");
		list.add(
				"53,'Bayside Ladies Usa-Made V-Neck PoloNavy Medium',1,18.74,'T-Shirt','Bayside Apparel',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS_54079-Navy-M.jpg'),'raghu',now(),'SS_54079-Navy-M','M'");
		list.add(
				"54,'Inner Harbor Ladies Mainsail Pique Polo (Red) (3X)',1,21.86,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000409.jpg'),'raghu',now(),'56504000409','3XL'");
		list.add(
				"55,'Jonathan Corey Ladies Fine Pima Pique Polo (Aqua) (L)',1,18.89,'T-Shirt','Jonathan Corey',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56447516906.jpg'),'raghu',now(),'56447516906','L'");
		list.add(
				"56,'Inner Harbor Ladies Mainsail Pique Polo (Red) (L)',1,18.4,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000406.jpg'),'raghu',now(),'56504000406','L'");
		list.add(
				"57,'Inner Harbor Ladies Mainsail Pique Polo (Black) (2X)',1,20.12,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000508.jpg'),'raghu',now(),'56504000508','XXL'");
		list.add(
				"58,'Inner Harbor Ladies Mainsail Pique Polo (Black) (4X)',1,25.14,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000510.jpg'),'raghu',now(),'56504000510','4XL'");
		list.add(
				"59,'Inner Harbor Ladies Mainsail Pique Polo (Red) (M)',1,22.63,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000405.jpg'),'raghu',now(),'56504000405','M'");
		list.add(
				"60,'Russell Womens Ultimate Pique Cotton Short Sleeve Polo Shirt Black XXL',1,12.3,'Shirt','Russell Athletic',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\577F_BLK_23XXL.jpg'),'raghu',now(),'577F_BLK_23XXL','S'");
		list.add(
				"61,'Inner Harbor Ladies Mainsail Pique Polo (Foxy Grey) (4X)',1,55.9,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504017010.jpg'),'raghu',now(),'56504017010','4XL'");
		list.add(
				"62,'Inner Harbor Ladies Mainsail Pique Polo (Purple) (3X)',1,55.1,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504001909.jpg'),'raghu',now(),'56504001909','3XL'");
		list.add(
				"63,'Inner Harbor Ladies Mainsail Pique Polo (Sangria) (4X)',1,664.33,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504017110.jpg'),'raghu',now(),'56504017110','4XL'");
		list.add(
				"64,'Ladies Page & Tuttle Cool Swing Tipped RaglanGold LeafL',1,22.9,'T-Shirt','PAGE & TUTTLE',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS402090739F1003.jpg'),'raghu',now(),'BZS402090739F1003','L'");
		list.add(
				"65,'Cool Kaftans SWING Black Butterfly Blouse Tunic Long Top Fits Size 22-26',1,12.4,'T-Shirt','Cool Kaftans',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\Kaf-App-78.jpg'),'raghu',now(),'Kaf-App-78','S'");
		list.add(
				"66,'Ladies Page & Tuttle Cool Swing Tipped RaglanBlackS',1,25.6,'T-Shirt','PAGE & TUTTLE',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS40209073103001.jpg'),'raghu',now(),'BZS40209073103001','S'");
		list.add(
				"67,'Womens Slim-cut Ashworth Classic Solid Pique PoloNavyM',1,23.31,'T-Shirt','Ashworth',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS40188912232002.jpg'),'raghu',now(),'BZS40188912232002','M'");
		list.add(
				"68,'Womens Slim-cut Ashworth Classic Solid Pique PoloNavyS',1,23.74,'T-Shirt','Ashworth',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS40188912232001.jpg'),'raghu',now(),'BZS40188912232001','S'");
		list.add(
				"69,'Inner Harbor Ladies Mainsail Pique Polo (White) (3X)',1,12.65,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000809.jpg'),'raghu',now(),'56504000809','3XL'");
		list.add(
				"70,'Inner Harbor Ladies Mainsail Pique Polo (Foxy Grey) (3X)',1,224.3,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504017009.jpg'),'raghu',now(),'56504017009','3XL'");
		list.add(
				"71,'Page & Tuttle Womens Cool Swing Short Sleeve PoloGecko GreenM',1,66.6,'T-Shirt','PAGE & TUTTLE',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS402090719F0002.jpg'),'raghu',now(),'BZS402090719F0002','M'");
		list.add(
				"72,'Ladies Page & Tuttle Cool Swing Tipped RaglanOlympic BlueS',1,23.4,'T-Shirt','PAGE & TUTTLE',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS402090739J6001.jpg'),'raghu',now(),'BZS402090739J6001','S'");
		list.add(
				"73,'Inner Harbor Ladies Mainsail Pique Polo (Bimini Blue) (3X)',1,45.6,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504009409.jpg'),'raghu',now(),'56504009409','3XL'");
		list.add(
				"74,'Ladies Page & Tuttle Cool Swing Tipped RaglanBlackL',1,98.3,'T-Shirt','PAGE & TUTTLE',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS40209073103003.jpg'),'raghu',now(),'BZS40209073103003','L'");
		list.add(
				"75,'Womens Slim-cut Ashworth Classic Solid Pique PoloBambooL',1,66.6,'T-Shirt','Ashworth',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS40188912CT7003.jpg'),'raghu',now(),'BZS40188912CT7003','L'");
		list.add(
				"76,'Womens Slim-cut Ashworth Classic Solid Pique PoloAbsolute BlueM',1,44.6,'T-Shirt','Ashworth',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS401889122E4002.jpg'),'raghu',now(),'BZS401889122E4002','M'");
		list.add(
				"77,'Jonathan Corey Ladies Short Sleeve Easy Care Soil Release Twill (Red) (XL)',1,469.3,'T-Shirt','Jonathan Corey',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56470000407.jpg'),'raghu',now(),'56470000407','XL'");
		list.add(
				"78,'Womens Page & Tuttle Cool Swing PinstripeTrue TurquoiseM',1,74.3,'T-Shirt','PAGE & TUTTLE',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS402090689N5002.jpg'),'raghu',now(),'BZS402090689N5002','M'");
		list.add(
				"79,'Womens Slim-cut Ashworth Classic Solid Pique PoloNavyL',1,78.12,'T-Shirt','Ashworth',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS40188912232003.jpg'),'raghu',now(),'BZS40188912232003','L'");
		list.add(
				"80,'Womens Slim-cut Ashworth Classic Solid Pique PoloWhiteM',1,75.32,'T-Shirt','Ashworth',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS40188912100002.jpg'),'raghu',now(),'BZS40188912100002','M'");
		list.add(
				"81,'Inner Harbor Ladies Mainsail Pique Polo (Bimini Blue) (2X)',1,79.96,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504009408.jpg'),'raghu',now(),'56504009408','XXL'");
		list.add(
				"82,'Inner Harbor Ladies Mainsail Pique Polo (Sangria) (S)',1,71.65,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504017104.jpg'),'raghu',now(),'56504017104','S'");
		list.add(
				"83,'Inner Harbor Ladies Mainsail Pique Polo (Foxy Grey) (2X)',1,87.6,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504017008.jpg'),'raghu',now(),'56504017008','XXL'");
		list.add(
				"84,'Inner Harbor Ladies Mainsail Pique Polo (Purple) (S)',1,22.6,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504001904.jpg'),'raghu',now(),'56504001904','S'");
		list.add(
				"85,'Inner Harbor Ladies Mainsail Pique Polo (Royal) (4X)',1,22.63,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000610.jpg'),'raghu',now(),'56504000610','4XL'");
		list.add(
				"86,'Russell Womens Pique Cotton Short Sleeve Polo Shirt Sky S',1,24.12,'Shirt','Russell Athletic',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\569F_SKY_7S.jpg'),'raghu',now(),'569F_SKY_7S','S'");
		list.add(
				"87,'Inner Harbor Ladies Mainsail Pique Polo (White) (4X)',1,25.16,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504000810.jpg'),'raghu',now(),'56504000810','4XL'");
		list.add(
				"88,'INNER HARBOR Ladies Basic Import PiqueChino4XL',1,25.89,'Top','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504016610.jpg'),'raghu',now(),'56504016610','4XL'");
		list.add(
				"89,'Jonathan Corey Ladies Long Sleeve Easy Care Brushed Twill (Navy) (XL)',1,32.66,'T-Shirt','Jonathan Corey',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56467500107.jpg'),'raghu',now(),'56467500107','XL'");
		list.add(
				"90,'Style 200 Ladies Short Sleeve Pima Cotton Shirt',1,32.45,'Shirt','Jonathan Corey',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56447529507.jpg'),'raghu',now(),'56447529507','S'");
		list.add(
				"91,'Jonathan Corey Ladies Fine Pima Pique Polo (Sangria) (S)',1,45.6,'T-Shirt','Jonathan Corey',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56447517104.jpg'),'raghu',now(),'56447517104','S'");
		list.add(
				"92,'Inner Harbor Ladies Mainsail Pique Polo (Sangria) (M)',1,46.9,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504017105.jpg'),'raghu',now(),'56504017105','M'");
		list.add(
				"93,'Womens Slim-cut Ashworth Classic Solid Pique PoloAbsolute BlueL',1,22.6,'T-Shirt','Ashworth',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\BZS401889122E4003.jpg'),'raghu',now(),'BZS401889122E4003','L'");
		list.add(
				"94,'Jonathan Corey Ladies Long Sleeve Easy Care Soil Release Twill (Red) (L)',1,18.9,'Top','Jonathan Corey',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56469500406.jpg'),'raghu',now(),'56469500406','L'");
		list.add(
				"95,'Inner Harbor Ladies Mainsail Pique Polo (Sangria) (3X)',1,19.65,'T-Shirt','INNER HARBOR',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\56504017109.jpg'),'raghu',now(),'56504017109','3XL'");
		list.add(
				"96,'Dickies - 1254 Womens Button-Down Oxford Shirt - Short SleeveSize: 20Color: Light Blue',1,14.6,'Shirt','Dickies',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\DI-1254-20--LB.jpg'),'raghu',now(),'DI-1254-20--LB','S'");
		list.add(
				"97,'Bench 3/4 Sleeve Top',1,15.7,'Top','Bench',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\B00RDED2VABright WhiteM.jpg'),'raghu',now(),'B00RDED2VABright WhiteM','M'");
		list.add(
				"98,'UltraClubÂ® Ladies Cool & Dry Elite Performance Polo - Royal - M',1,16.9,'T-Shirt','UltraClub',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\8414-33-M.jpg'),'raghu',now(),'8414-33-M','M'");
		list.add(
				"99,'Scotch & Soda Womens Striped Logo T-ShirtPBlack',1,17.21,'Shirt','Scotch & Soda',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\15260651606_A_34 (P).jpg'),'raghu',now(),'15260651606_A_34 (P)','S'");
		list.add(
				"100,'Code V Ladies 4 oz. Fine Jersey Camouflage T-ShirtX-LargeGreen Woodland',1,14.97,'Shirt','Code Five',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\LA4-3665-XL-Green Woodland.jpg'),'raghu',now(),'LA4-3665-XL-Green Woodland','XL'");
		list.add(
				"101,'58800 Van Heusen Ladiesâ€™ Classic Long-Sleeve Oxford (Dark Grey) (2XL)',1,10.6,'Top','Van Heusen',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\55288001207.jpg'),'raghu',now(),'55288001207','XXL'");
		list.add(
				"102,'8530 UltraClub Womens Classic PiquÃ© Polo Cornflower 2X-Large',1,8.8,'T-Shirt','UltraClub',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\8530-14-2XL.jpg'),'raghu',now(),'8530-14-2XL','XXL'");
		list.add(
				"103,'Dickies - 1254 Womens Button-Down Oxford Shirt - Short SleeveSize: 14Color: Light Blue',1,6.5,'Shirt','Dickies',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\DI-1254-14--LB.jpg'),'raghu',now(),'DI-1254-14--LB','S'");
		list.add(
				"104,'Van Heusen Ladies Long-Sleeve Blended Pinpoint Oxford',1,8.23,'T-Shirt','Van Heusen',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Mint-1440-XL.jpg'),'raghu',now(),'HT-2001_Mint-1440-XL','XL'");
		list.add(
				"105,'Devon & Jones Womens Executive Club Polo',1,4.65,'T-Shirt','Devon & Jones',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\D440W-XL-NEW BUTTER.jpg'),'raghu',now(),'D440W-XL-NEW BUTTER','XL'");
		list.add(
				"106,'HA LAD 4 OZ POLYTECH POLO (RED) (S)',1,5.25,'T-Shirt','Harriton',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\AL-M315W-Red-S.jpg'),'raghu',now(),'AL-M315W-Red-S','S'");
		list.add(
				"107,'Jerzees Spotshield 50/50 Long Sleeve Sport ShirtTrue Navy Large',1,12.6,'Shirt','Jerzees',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Cranberry-1167-XL.jpg'),'raghu',now(),'HT-2001_Cranberry-1167-XL','XL'");
		list.add(
				"108,'Vans Womens Lana Printed Dress Leopard Print Small',1,13.9,'Top','Vans',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\VVXXCQ9_Biscuit_S.jpg'),'raghu',now(),'VVXXCQ9_Biscuit_S','S'");
		list.add(
				"109,'Comfort Colors Ladies 5.4 oz. Ringspun Garment-Dyed T-Shirt>2XL WATERMELON',1,14.9,'Shirt','Comfort Colors',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\3333-41-2XL.jpg'),'raghu',now(),'3333-41-2XL','XL'");
		list.add(
				"110,'Bench 3/4 Sleeve Top',1,15.1,'Top','Bench',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\B00RDED314Bright WhiteL.jpg'),'raghu',now(),'B00RDED314Bright WhiteL','L'");
		list.add(
				"111,'Columbia Womens Plus-Size Tamiami II Long Sleeve ShirtBright Rose2X',1,16.31,'Shirt','Columbia',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\141030747.jpg'),'raghu',now(),'141030747','S'");
		list.add(
				"112,'Jerzees Spotshield 50/50 Long Sleeve Sport ShirtForest Green X-Large',1,15.6,'Shirt','Jerzees',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_BabyBlue-1167-2XL.jpg'),'raghu',now(),'HT-2001_BabyBlue-1167-2XL','XXL'");
		list.add(
				"113,'Van Heusen 59800 Ladies Long-Sleeve Wrinkle-Resistant Oxford - Dark Grey - Xl',1,17.8,'Top','Van Heusen',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\55287001206.jpg'),'raghu',now(),'55287001206','XL'");
		list.add(
				"114,'Comfort Colors C4100 Ladies Ringspun Garment-Dyed T-Shirt - Pepper - S',1,18.45,'Shirt','Comfort Colors',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\B02768113.jpg'),'raghu',now(),'B02768113','S'");
		list.add(
				"115,'Jerzees Spotshield 50/50 Long Sleeve Sport ShirtTrue Red Large',1,19.2,'Shirt','Jerzees',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\HT-2001_Creme-1167-XL.jpg'),'raghu',now(),'HT-2001_Creme-1167-XL','XL'");
		list.add(
				"116,'Dickies Womens Short Sleeve Stretch Poplin Classic ShirtWhiteX-Large',1,21.22,'Shirt','Dickies',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\DI-FS010-XL--WH.jpg'),'raghu',now(),'DI-FS010-XL--WH','XL'");
		list.add(
				"117,'Polarmax Womens Tech Silk LS Crew 2015 (BlackX-Small)',1,22.33,'Top','Polarmax',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\1D31N_____XS-BLK.jpg'),'raghu',now(),'1D31N_____XS-BLK','S'");
		list.add(
				"118,'The North Face Reaxion Short Sleeve Tee Shirt - Womens - Heather Grey In Size: Small',1,24.66,'Shirt','The North Face',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\T0A1JV_054-S.jpg'),'raghu',now(),'T0A1JV_054-S','S'");
		list.add(
				"119,'Bench 3/4 Sleeve Top',1,25.77,'Top','Bench',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\B00RDECZUEBright WhiteS.jpg'),'raghu',now(),'B00RDECZUEBright WhiteS','S'");
		list.add(
				"120,'Glamorous Womens Womans Shirt In Light Blue Color in Size M Blue',1,26.88,'Shirt','Glamorous',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\KA4927-N57_12 (M).jpg'),'raghu',now(),'KA4927-N57_12 (M)','S'");
		list.add(
				"121,'Fruit of the Loom Womens Fit Oxford Short Sleeve Shirt White S',1,27.12,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS471_WHI_7S.jpg'),'raghu',now(),'SS471_WHI_7S','S'");
		list.add(
				"122,'Fruit of the Loom Lady-fit poplin short sleeve shirt Red L',1,28.33,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_RED_15L.jpg'),'raghu',now(),'SS481_RED_15L','L'");
		list.add(
				"123,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt White S',1,29.44,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_WHI_7S.jpg'),'raghu',now(),'SS481_WHI_7S','S'");
		list.add(
				"124,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt Black M',1,30.12,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_BLK_11M.jpg'),'raghu',now(),'SS481_BLK_11M','M'");
		list.add(
				"125,'Vero Moda Womens Crinkle Openwork Short Sleeve Top in Mandarin Red Size Small',1,31.26,'Top','VERO MODA',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\B01A6W0RP4Rot 36.jpg'),'raghu',now(),'B01A6W0RP4Rot 36','M'");
		list.add(
				"126,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt Red XXL',1,32.66,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_RED_23XXL.jpg'),'raghu',now(),'SS481_RED_23XXL','XXL'");
		list.add(
				"127,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt White XXL',1,33.54,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_WHI_23XXL.jpg'),'raghu',now(),'SS481_WHI_23XXL','XXL'");
		list.add(
				"128,'Glamorous Womens Womans Shirt In Light Blue Color in Size XS Blue',1,34.89,'Shirt','Glamorous',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\KA4927-N57_8 (X-Small).jpg'),'raghu',now(),'KA4927-N57_8 (X-Small)','S'");
		list.add(
				"129,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt Mid Blue M',1,35.64,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_MBL_11M.jpg'),'raghu',now(),'SS481_MBL_11M','M'");
		list.add(
				"130,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt White L',1,36.44,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_WHI_15L.jpg'),'raghu',now(),'SS481_WHI_15L','L'");
		list.add(
				"131,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt Mid Blue S',1,37.44,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_MBL_7S.jpg'),'raghu',now(),'SS481_MBL_7S','M'");
		list.add(
				"132,'UltraClub Womens Wrinkle-Free End-on-End ShirtMediumCadet Blue',1,38.11,'Shirt','UltraClub',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\GA-101500-8341.jpg'),'raghu',now(),'GA-101500-8341','M'");
		list.add(
				"133,'Glamorous Womens Womans Shirt In Light Blue Color in Size S Blue',1,39.78,'Shirt','Glamorous',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\KA4927-N57_10 (Small).jpg'),'raghu',now(),'KA4927-N57_10 (Small)','S'");
		list.add(
				"134,'Fruit of the Loom Womens Fit Poplin Short Sleeve Shirt Navy L',1,40.89,'Shirt','Fruit of the Loom',now(),'test desc',load_file('C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\images\\\\SS481_NAV_15L.jpg'),'raghu',now(),'SS481_NAV_15L','L'");

		Map<String, String> out = new LinkedHashMap<>();
		for (String s : list) {
			String[] ss = s.split(",");
			Pattern pattern = Pattern.compile("(?<=load_file\\()(.*)(?=jpg)");
			Matcher matcher = pattern.matcher(s);
			while (matcher.find()) {
				out.put(ss[0], matcher.group().replace("'", "") + "jpg");
				System.out.println(new File(matcher.group().replace("'", "") + "jpg").getAbsoluteFile());
			}
		}
		return out;
	}

}
