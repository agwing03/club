package com.club.business.board;

import java.util.List;

import com.club.sys.cmmn.CamelMap;
import com.club.sys.cmmn.CommonVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO extends CommonVO{
    /**
	 * 게시판 공통 VO 
	 * table : board, board_reply
	 */
	private int 	boardNo;
	private int 	clubNo;
	private String 	title;
	private String 	contents;
	private String 	boardGbn;
	private int 	replyCnt;
	private int 	fileId = 0;
	
	private List<CamelMap> boardList; 	//게시물 목록
	private List<CamelMap> repleList; 	//리플 목록
	private List<CamelMap> fileList; 	//파일 목록 
}
