package evolution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import evolution.entity.AnotherEntity;
import evolution.entity.AnyEntity;

@Mapper// Once defined, you can @Autowired this mapper.
public interface AnyMapper {// Corresponds to anyMapper.xml
	public List<AnyEntity> selectByName(String name);
	
	public List<AnyEntity> selectAll();
	
	public int selectCount();// Both int and Integer work.
	
	public List<String> selectNames();
	
	public List<AnotherEntity> selectIdsAndNames();
}
