package kr.ac.kopo.board.service;

import kr.ac.kopo.board.DTO.BoardDTO;
import kr.ac.kopo.board.DTO.PageRequestDTO;
import kr.ac.kopo.board.DTO.PageResultDTO;
import kr.ac.kopo.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardDTO dto = BoardDTO.builder()
                .title("Board Test...")
                .content("Board Test Board Test Board Test")
                .writerEmail("user7@kopo.ac.kr")
                .build();
        Long bno = boardService.register(dto);
        System.out.println("정상적으로 글이 저장되었습니다. : "+bno);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for (BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
    }

    @Test
    public void testGet(){
        Long bno = 3L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    @Test
    public void testRemove(){
        Long bno = 3L;
        boardService.removeWithReplies(bno);
    }




}
