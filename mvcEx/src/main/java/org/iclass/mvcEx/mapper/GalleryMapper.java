package org.iclass.mvcEx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvcEx.dto.Gallery;

@Mapper
public interface GalleryMapper {
	int insert(Gallery dto); 
	List<Gallery> selectAll();
}