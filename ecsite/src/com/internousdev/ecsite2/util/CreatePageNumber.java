package com.internousdev.ecsite2.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.CreatePageNumberDTO;

public class CreatePageNumber {

	public CreatePageNumberDTO getPage(List<BuyItemDTO> list,int pageSize,int pageNo) {
		CreatePageNumberDTO createPageNumberDTO = new CreatePageNumberDTO();
		createPageNumberDTO.setTotalPageSize((int)(Math.ceil((double)list.size() / pageSize))); // 全ページ数
		createPageNumberDTO.setNowPageNo(pageNo); // 現在のページ番号
		createPageNumberDTO.setStartItemListNo(pageSize * (createPageNumberDTO.getNowPageNo() - 1));// 現在のページ番号に対する開始レコード番号
		createPageNumberDTO.setEndItemListNo(createPageNumberDTO.getStartItemListNo() + (pageSize - 1));// 現在のページ番号に対する終了レコード番号

		List<BuyItemDTO> nowPageIteminfo = new ArrayList<BuyItemDTO>();
		for(int i = createPageNumberDTO.getStartItemListNo(); i <= createPageNumberDTO.getEndItemListNo(); i++) {
			if(i > list.size() - 1) {
				break;
			}
			nowPageIteminfo.add(list.get(i));
		}
		createPageNumberDTO.setNowPageIteminfo(nowPageIteminfo);

		return createPageNumberDTO;

	}

}
