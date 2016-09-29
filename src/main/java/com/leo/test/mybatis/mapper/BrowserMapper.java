package com.leo.test.mybatis.mapper;

import com.leo.test.mybatis.model.Browser;

/**
 * Created by Senchenko Viktor on 27.09.2016.
 */
public interface BrowserMapper extends Mapper<Browser> {
    // TODO Mapper can be writen by annotation
    //    @Select("SELECT * FROM browser")
    //    @Results({@Result(property = "cssGrade", column = "css_grade"), @Result(property = "engineVersion", column = "engine_version"),})
    //    public List<Browser> list();
    //
    //    @Select("SELECT * FROM browser WHERE id = #{id}")
    //    @Results({@Result(property = "cssGrade", column = "css_grade"), @Result(property = "engineVersion", column = "engine_version"),})
    //    public Browser get(Serializable id);
    //
    //    @Delete("DELETE FROM `browser` WHERE id = #{id}")
    //    public void delete(Browser browser);
    //
    //    @Insert("INSERT `browser` SET `browser`=#{browser}, `css_grade`=#{cssGrade}, `engine`=#{engine}, `engine_version`=#{engineVersion}, `platform`=#{platform}")
    //    @Options(useGeneratedKeys = true)
    //    public void create(Browser browser);
    //
    //    @Update("UPDATE `browser` SET `browser`=#{browser}, `css_grade`=#{cssGrade}, `engine`=#{engine}, `engine_version`=#{engineVersion}, `platform`=#{platform} WHERE id = #{id}")
    //    public void edit(Browser browser);
}
