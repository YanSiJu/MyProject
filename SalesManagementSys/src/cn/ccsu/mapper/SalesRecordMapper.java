package cn.ccsu.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.SalesRecord;

@Repository
public interface SalesRecordMapper {
	// 增加销售记录
	void addSalesRecord(SalesRecord record);

	// 查询销售记录
	List<SalesRecord> selectSalesRecord(Map<String, Object> params);

	// 查询所有销售记录
	List<SalesRecord> selectAllSalesRecords();

	// 更新销售记录
	void updateSalesRecord(SalesRecord record);

	// 删除销售记录
	void deleteSalesRecord(Integer recordId);

	// 根据id查询销售记录
	SalesRecord selectSalesRecordById(Integer recordId);
}
