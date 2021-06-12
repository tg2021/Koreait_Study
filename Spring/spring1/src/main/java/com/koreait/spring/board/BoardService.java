package com.koreait.spring.board;

import com.koreait.spring.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {

    /*
        의존 자동 주입
        기능을 사용하면 스프링이 알아서 의존 객체를 찾아서 주입해준다.
     */
    @Autowired
    private BoardMapper mapper;
    @Autowired
    private BoardCmtMapper cmtMapper;
    @Autowired
    private MyUtils myUtils;


    public List<BoardDomain> selBoardList(BoardDTO param) {
        param.setIuser(myUtils.getLoginUserPk());
        // paging
        int startIdx = (param.getPage() - 1) * param.getRecordCnt();
        param.setStartIdx(startIdx);

        return mapper.selBoardList(param);
    }

    public int selMaxPageVal(BoardDTO param) {
        return mapper.selMaxPageVal(param);
    }

    public BoardDomain selBoard(BoardDTO param) {
        return mapper.selBoard(param);
    }

    // return값은 iboard
    public int writeMod(BoardEntity param) {
        param.setIuser(myUtils.getLoginUserPk());
        // iboard(0), title, ctnt, iuser
        if(param.getIboard() == 0) {
           //등록
            mapper.insBoard(param);
        } else  { // 수정
            mapper.updBoard(param);
        }

        return param.getIboard();
    }

    public int delBoard(BoardEntity param) {
        // 댓글 먼저 삭제한다.
        BoardCmtEntity cmtParam = new BoardCmtEntity();
        cmtParam.setIboard(param.getIboard());
        cmtMapper.delBoardCmt(cmtParam);

        param.setIuser(myUtils.getLoginUserPk());
        return mapper.delBoard(param);
    }

    public int insBoardCmt(BoardCmtEntity param) {
        param.setIuser(myUtils.getLoginUserPk());
        return cmtMapper.insBoardCmt(param);
    }

    public List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param) {
        return cmtMapper.selBoardCmtList(param);
    }

    public int updBoardCmt(BoardCmtEntity param) {
        param.setIuser(myUtils.getLoginUserPk());
        return cmtMapper.updBoardCmt(param);
    }

    public int delBoardCmt(BoardCmtEntity param) {
        param.setIuser(myUtils.getLoginUserPk());
        return cmtMapper.delBoardCmt(param);
    }


}
