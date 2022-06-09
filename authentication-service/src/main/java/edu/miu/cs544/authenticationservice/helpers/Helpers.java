package edu.miu.cs544.authenticationservice.helpers;

import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class Helpers {
    public static List<String> decode(String encoded){
        String[] actualString = encoded.split("\\.");
        var r = Base64.getDecoder().decode(actualString[1]);

        return Arrays.asList(r).stream().map(a -> new String(a)).collect(Collectors.toList());
    }

}
