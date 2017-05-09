package evolution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import evolution.entity.AnyEntity;

@Mapper
public interface AnyMapper {
	public List<AnyEntity> selectByName(String name);
}
