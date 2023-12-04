package util;

import java.util.Arrays;
import java.util.List;

public class PlayerInputPolicyChecker implements PolicyChecker{


    @Override
    public void policyCheck(String names) {
        checkName(names);
    }

    private void checkName(String names) {
        long count = countComma(names);
        checkBlank(names,count);
        List<String> split = Arrays.asList((names.split(", ")));
        checkComma(count, split);
    }

    private void checkComma(long count, List<String> split) {
        if(split.size()-1 != count)
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다!");
    }

    private void checkBlank(String names, long count) {
         if(names.chars().filter(name -> name == ' ').count() != count)
             throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다!");
    }

    private long countComma(String names) {
        return names.chars().filter(name -> name == ',').count();
    }


}
