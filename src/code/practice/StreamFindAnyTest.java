package code.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFindAnyTest {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(3,4,5,6,null,7,0);
        final List<Integer> infos = myList.stream().
                filter(eachChannel -> eachChannel == null).
                collect(Collectors.toList());
        infos.stream().forEach(System.out::println);
        
        final boolean isNullPresent = myList.stream().anyMatch(each -> each == null);
        System.out.println(isNullPresent);

    }

}
