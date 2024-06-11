package com.stockholm.main_project.board.mapper;

import com.stockholm.main_project.board.commnet.entity.Comment;
import com.stockholm.main_project.board.dto.BoardRequestDto;
import com.stockholm.main_project.board.dto.responseDto.AllBoardResponseDto;
import com.stockholm.main_project.board.dto.responseDto.BoardCommentDto;
import com.stockholm.main_project.board.dto.responseDto.SingleBoardResponseDto;
import com.stockholm.main_project.board.entity.Board;
import com.stockholm.main_project.member.entity.Member;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T16:22:25+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public Board boardRequestToBoard(BoardRequestDto requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Board board = new Board();

        board.setContent( requestBody.getContent() );
        board.setTitle( requestBody.getTitle() );

        return board;
    }

    @Override
    public SingleBoardResponseDto boardToBoardResponseDto(Board board) {
        if ( board == null ) {
            return null;
        }

        SingleBoardResponseDto singleBoardResponseDto = new SingleBoardResponseDto();

        singleBoardResponseDto.setMember( boardMemberName( board ) );
        singleBoardResponseDto.setBoardId( board.getBoardId() );
        singleBoardResponseDto.setContent( board.getContent() );
        if ( board.getCreatedAt() != null ) {
            singleBoardResponseDto.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( board.getCreatedAt() ) );
        }
        if ( board.getModifiedAt() != null ) {
            singleBoardResponseDto.setModifiedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( board.getModifiedAt() ) );
        }
        singleBoardResponseDto.setTitle( board.getTitle() );

        return singleBoardResponseDto;
    }

    @Override
    public AllBoardResponseDto boardToAllBoardResponseDto(Board board) {
        if ( board == null ) {
            return null;
        }

        AllBoardResponseDto allBoardResponseDto = new AllBoardResponseDto();

        allBoardResponseDto.setMember( boardMemberName( board ) );
        allBoardResponseDto.setBoardId( board.getBoardId() );
        allBoardResponseDto.setContent( board.getContent() );
        if ( board.getCreatedAt() != null ) {
            allBoardResponseDto.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( board.getCreatedAt() ) );
        }
        if ( board.getModifiedAt() != null ) {
            allBoardResponseDto.setModifiedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( board.getModifiedAt() ) );
        }
        allBoardResponseDto.setTitle( board.getTitle() );

        return allBoardResponseDto;
    }

    @Override
    public BoardCommentDto boardCommentToBoardCommentsDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        BoardCommentDto boardCommentDto = new BoardCommentDto();

        boardCommentDto.setMember( commentMemberName( comment ) );
        if ( comment.getCommentId() != null ) {
            boardCommentDto.setCommentId( comment.getCommentId() );
        }
        boardCommentDto.setContent( comment.getContent() );
        if ( comment.getCreatedAt() != null ) {
            boardCommentDto.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( comment.getCreatedAt() ) );
        }
        if ( comment.getModifiedAt() != null ) {
            boardCommentDto.setModifiedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( comment.getModifiedAt() ) );
        }

        return boardCommentDto;
    }

    private String boardMemberName(Board board) {
        if ( board == null ) {
            return null;
        }
        Member member = board.getMember();
        if ( member == null ) {
            return null;
        }
        String name = member.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String commentMemberName(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Member member = comment.getMember();
        if ( member == null ) {
            return null;
        }
        String name = member.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
