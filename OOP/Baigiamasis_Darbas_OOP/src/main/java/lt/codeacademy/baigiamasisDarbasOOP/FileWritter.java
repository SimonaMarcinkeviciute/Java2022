/*package lt.codeacademy.baigiamasisDarbasOOP;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileWritter {

  public void objectWritter(File fileName, List<Student> objects) {
      ObjectMapper mapper = new ObjectMapper();
      mapper.enable(SerializationFeature.INDENT_OUTPUT);



      try {
          mapper.writeValue(fileName, objects);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
} */
