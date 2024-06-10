package com.server.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
		
	}

}

//		CityServiceStart c = new CityServiceStart();
//		c.setAllCitiesToDatabank();

//		@Autowired
//		CityService citiService;
//		try {
//			citiService.saveCity();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		startCitiesService();

		// save data in db
//		JsonParser jsonParser = new JsonParser();
//
//		try {
//			CitiesRootInfoFromJsonDTO citiesRootJson = jsonParser.parseCitiesJson("src\\main\\resources\\temp\\citiesDe.json");
//			System.out.println("Info from Json file: Version = " + citiesRootJson.getVersion());
//			for (CitiesElementFromJsonDTO el: citiesRootJson.getElements()) {
//				
//				System.out.println(el.getTags());
//			}
//
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// System.out.println("Current working directory: " + new
		// File(".").getAbsolutePath());
		//
//				String inputFilePath = "server\\src\\main\\resources\\static\\DE.txt"; // Замените на путь к вашему файлу
//				String outputFilePath = "server\\src\\main\\resources\\static\\DE.csv"; // Замените на путь, куда вы хотите сохранить CSV
		//
//				try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
//					 FileWriter fw = new FileWriter(outputFilePath)) {
		//
//					String line;
//					while ((line = br.readLine()) != null) {
//						String[] values = line.split("\t");
//						fw.write(String.join(",", values));
//						fw.write("\n");
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}

