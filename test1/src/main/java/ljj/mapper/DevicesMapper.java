package ljj.mapper;

import java.util.List;
import ljj.pojo.Devices;
import ljj.pojo.DevicesExample;
import org.apache.ibatis.annotations.Param;

public interface DevicesMapper {
    int countByExample(DevicesExample example);

    int deleteByExample(DevicesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Devices record);

    int insertSelective(Devices record);

    List<Devices> selectByExample(DevicesExample example);

    Devices selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByExample(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByPrimaryKeySelective(Devices record);

    int updateByPrimaryKey(Devices record);
}