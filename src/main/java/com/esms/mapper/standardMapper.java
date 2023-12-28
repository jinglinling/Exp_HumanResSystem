package com.esms.mapper;
import java.util.List;
import com.esms.entity.standard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface standardMapper {
    void addstandard(standard m);
    void deletestandard(String m);
    standard getstandardbyNo(String No);
    List<standard> getstandardbykeyword(String keyword);
    List<standard> getstandardbyDate(@Param("before")String before,@Param("after") String after);
    void updatestandard(standard m);
    List<standard> getallstandard();
}
