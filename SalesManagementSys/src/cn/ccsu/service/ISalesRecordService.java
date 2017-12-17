package cn.ccsu.service;

import java.util.List;
import cn.ccsu.entity.SalesRecord;

public interface ISalesRecordService {

	// 增加销售记录
	int addSalesRecord(SalesRecord record);

	// 查询销售记录
	List<SalesRecord> querySalesRecord(Integer productId, Integer salesmanId, Integer recordId);

	// 更新销售记录
	int modifySalesRecord(SalesRecord record);

	// 查询所有销售记录
	List<SalesRecord> queryAllRecords();


	// 删除销售记录
	void deleteSalesRecord(Integer recordId);
}
