package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 무조건 적어줘야 @RequestMapping할 수 있다.
// 고객의 요청이 왔을때 메소드를 후출시키는 기능
@Controller 
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping("/list")
    public String list(Model model) {
        List<BoardDomain> list = service.selBoardList();
        model.addAttribute("list", list);
        return "board/list";
    }

    @RequestMapping("/detail")
    public String detail(BoardDTO param, Model model) {
        System.out.println("iboard : " + param.getIboard());
        // 값을 가져온다
        BoardDomain data = service.selBoard(param);
        // 값을 담는다
        model.addAttribute("data", data);
        return "board/detail";
    }
    
    /*
        Map은 forEach를 사용할 수 없다 = for문도 사용할 수 없다
        비슷한게 있다
     */
    @ResponseBody // return 타입을 JSON의 문자화 시켜준다, HTML태그를 안쓰기위함
    @RequestMapping(value = "/cmtIns", method = RequestMethod.POST)
    public Map<String, Integer> cmtIns(@RequestBody BoardCmtEntity param) {
        /*
        @RequestBody는 JSON타입의 데이터를 전달해주거나 혹은 반대로
        JAVA의 객체데이터를 JSON형태로 프론트단에 전달해야 하는 경우 사용한다        
        */
        // service에서 값을 가저옴
        int result = service.insBoardCmt(param);
        
        Map<String, Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }

    @ResponseBody
    @RequestMapping("/cmtSel")
    public List<BoardCmtDomain> cmtSel(BoardCmtEntity param) {
        return  service.selBoardCmtList(param);
    }
}
