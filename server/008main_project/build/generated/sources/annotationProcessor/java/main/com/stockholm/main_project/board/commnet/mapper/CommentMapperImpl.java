package com.stockholm.main_project.board.commnet.mapper;

import com.stockholm.main_project.board.commnet.dto.CommentRequestDto;
import com.stockholm.main_project.board.commnet.dto.CommentResponseDto;
import com.stockholm.main_project.board.commnet.entity.Comment;
import com.stockholm.main_project.member.entity.Member;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T12:06:41+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment commentRequestDtoToComment(CommentRequestDto commentRequestDto) {
        if ( commentRequestDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setContent( commentRequestDto.getContent() );

        return comment;
    }

    @Override
    public CommentResponseDto commentToCommentResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseDto commentResponseDto = new CommentResponseDto();

        commentResponseDto.setMember( commentMemberName( comment ) );
        commentResponseDto.setCommentId( comment.getCommentId() );
        commentResponseDto.setContent( comment.getContent() );
        if ( comment.getCreatedAt() != null ) {
            commentResponseDto.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( comment.getCreatedAt() ) );
        }
        if ( comment.getModifiedAt() != null ) {
            commentResponseDto.setModifiedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( comment.getModifiedAt() ) );
        }

        return commentResponseDto;
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
