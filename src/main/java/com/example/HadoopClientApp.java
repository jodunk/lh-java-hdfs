package com.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class HadoopClientApp {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.addResource(new Path("src/main/resources/core-site.xml"));

            FileSystem fs = FileSystem.get(new URI("hdfs://namenode:9000"), conf);

            Path filePath = new Path("/user/hadoop/test.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fs.open(filePath)));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
