package com.koreait.spring1.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 무조건 적어줘야 @RequestMapping할 수 있다.
// 고객의 요청이 왔을때 메소드를 후출시키는 기능
@Controller // json 으로 보낸다
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping("/list")
    public String list(BoardDTO param, Model model) {
        model.addAttribute("list", service.selBoardList(param));
        model.addAttribute("maxPageVal", service.selMaxPageVal(param));
        return "board/list";
    }

    @RequestMapping("/detail")
    public String detail(BoardDTO param, Model model) {
        System.out.println("iboard : " + param.getIboard());
        // 값을 가져온다
        BoardDomain data = service.selBoard(param);
        // 값을 담는다
        model.addAttribute( "data", data);
        return "board/detail";
    }

    // get 방식
    @GetMapping("/writeMod")
    public void writeMod(BoardDTO param, Model model) {
        System.out.println("param = " + param);
        if(param.getIboard() > 0) {
            model.addAttribute("data", service.selBoard(param));
        }
    }

    // post 방식
    @PostMapping("/writeMod")
    public String writeModProc(BoardEntity param) {
        int iboard = service.writeMod(param);
        return "redirect:detail?iboard=" + iboard;
    }

    @GetMapping("/delBoard")
    public String delBoard(BoardEntity param) {
        service.delBoard(param);
        return "redirect:list";
    }

    /*
        Map은 forEach를 사용할 수 없다 = for문도 사용할 수 없다
        비슷한게 있다
     */
    @ResponseBody // return 타입을 JSON의 문자화 시켜준다, HTML태그를 안쓰기위함
    @RequestMapping(value = "/cmt", method = RequestMethod.POST)
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
    @RequestMapping("/cmt/{iboard}")
    /*
    {템플릿 변수} 와 동일한 이름을 갖는 파라미터를 추가
    @PathVariable의 ("iboard")는 변수명이 다르면 적어주는데 같으면 생략가능
    */

    // 빈등록이 되면 싱글톤
    public List<BoardCmtDomain> cmtSel(BoardCmtEntity param, @PathVariable("iboard") int iboard) {
        param.setIboard(iboard);
        return  service.selBoardCmtList(param);
    }

    @ResponseBody
    @RequestMapping(value = "/cmt/{icmt}", method = RequestMethod.DELETE)
    public Map<String, Integer> delBoardCmt(BoardCmtEntity param, @PathVariable("icmt") int icmt) {
        param.setIcmt(icmt);

        int result = service.delBoardCmt(param);

        Map<String, Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/cmt", method = RequestMethod.PUT)
    public Map<String, Integer> updBoardCmt(@RequestBody BoardCmtEntity param) {
       /*
            @RequestBody는
        */

        int result = service.updBoardCmt(param);
        Map<String, Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }

    @GetMapping("/favList")
    public void favList() {}


}
