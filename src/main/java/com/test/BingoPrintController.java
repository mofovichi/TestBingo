package com.test;

import com.test.model.BingoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("bingo")
public class BingoPrintController {

    List<List<BingoEntity>> bingoDatas;
    BingoPrintController(){
        this.bingoDatas = genData();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model){
        List<BingoEntity> bingoWord = new ArrayList<>();
        model.addAttribute("bingoWords", bingoDatas);
        return "bingo/bingo";

    }

    @RequestMapping(value="/find", method = RequestMethod.POST)
    String find(@RequestParam String word){
        updateBingo(word);
        System.out.println("update binog success !!!");
        return "redirect:/bingo";

    }

    private void updateBingo(String word){
        for(List<BingoEntity> entities : bingoDatas){
            entities.stream().forEach(be->{
                if(be.getWord().equals(word)){
                    be.setChecked(true);
                    return ;
                }
            });
        }

    }

    List<List<BingoEntity>> genData() {
        List<List<BingoEntity>> bingoDatas =new ArrayList<>();
        List<BingoEntity> bingoData1 = new ArrayList<>();
        List<BingoEntity> bingoData2 = new ArrayList<>();
        List<BingoEntity> bingoData3 = new ArrayList<>();

        BingoEntity bingoEntity1 = new BingoEntity("하나");
        BingoEntity bingoEntity2 = new BingoEntity("둘");
        BingoEntity bingoEntity3 = new BingoEntity("셋");
        BingoEntity bingoEntity4 = new BingoEntity("넷");
        BingoEntity bingoEntity5 = new BingoEntity("다섯");
        BingoEntity bingoEntity6 = new BingoEntity("여섯");
        BingoEntity bingoEntity7 = new BingoEntity("일곱");
        BingoEntity bingoEntity8 = new BingoEntity("여덟");
        BingoEntity bingoEntity9 = new BingoEntity("아홉");
        bingoData1.add(bingoEntity1);
        bingoData1.add(bingoEntity2);
        bingoData1.add(bingoEntity3);
        bingoData2.add(bingoEntity4);
        bingoData2.add(bingoEntity5);
        bingoData2.add(bingoEntity6);
        bingoData3.add(bingoEntity7);
        bingoData3.add(bingoEntity8);
        bingoData3.add(bingoEntity9);

        bingoDatas.add(bingoData1);
        bingoDatas.add(bingoData2);
        bingoDatas.add(bingoData3);

        return bingoDatas;
    }

}
