package com.exercise.rest.util;

import com.sun.codemodel.JCodeModel;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

public class JsonClassGenerator {

	public static void main(String[] args) {
		String jsonBeanName = "SearchWeatherDataResponse"; // The Pojo class name
		String jsonSchemaName = jsonBeanName + ".json"; // The Pojo class is same as json schema filename
		JCodeModel codeModel = new JCodeModel();
		try {
			URL source = new URL("file:///"+System.getProperty("user.dir")+"\\src\\main\\java\\com\\exercise\\rest\\jsonschemas\\"+jsonSchemaName);
			GenerationConfig config = new DefaultGenerationConfig() {
				@Override
				public boolean isGenerateBuilders() { // set config option by overriding method
					return true;
				}
				public SourceType getSourceType(){
					return SourceType.JSONSCHEMA;
				}
			};

			SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
			mapper.generate(codeModel, jsonBeanName, "com.exercise.rest.jsonclass", source);

			codeModel.build(new File("src\\main\\java"));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
}
