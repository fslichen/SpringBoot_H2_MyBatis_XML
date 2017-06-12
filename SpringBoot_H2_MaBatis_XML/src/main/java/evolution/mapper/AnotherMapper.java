package evolution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import evolution.entity.AnyEntity;

@Mapper// Once defined, you can @Autowired this mapper.
public interface AnotherMapper {// Corresponds to anotherMapper.xml
	public List<AnyEntity> findByOptionalName(@Param("name") String name);
	
	public List<AnyEntity> findByOptionalNameOrGender(@Param("name") String name, 
			@Param("gender") String gender);
	
	public void updateById(@Param("id") int id, @Param("name") String name, 
			@Param("gender") String gender);
	
	public List<AnyEntity> findByNames(@Param("names") List<String> names);
	
	public List<AnyEntity> findBySqlFragment();
}
