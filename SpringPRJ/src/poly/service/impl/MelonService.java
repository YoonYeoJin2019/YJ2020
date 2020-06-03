package poly.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.MelonDTO;
import poly.persistance.mongo.IMelonMapper;
import poly.service.IMelonService;
import poly.util.DateUtil;

@Service("MelonService")
public class MelonService implements IMelonService {

	@Resource(name="MelonMapper")
	private IMelonMapper melonmapper;

	@Override
	public int collectMelonRank() throws Exception {
	
		
		int res = 0;
		
		List<MelonDTO> pList = new ArrayList<MelonDTO>();
		
		String url = "https://www.melon.com/chart/index.htm";
		
		Document doc = null;
		
		doc = Jsoup.connect(url).get();
		
		Elements element = doc.select("div.service_list_song");
		
		Iterator<Element> rank50List = element.select("tr.lst50").iterator();
		
		while(rank50List.hasNext()) {
			Element songInfo = rank50List.next();
			
			String rank = songInfo.select("span.rank").text(); // 순위
			String song = songInfo.select("div.ellipsis a").eq(0).text();
			String singer = songInfo.select("div.ellipsis a").eq(1).text();
			String album = songInfo.select("div.ellipsis a").eq(3).text();
			
			songInfo = null;
			
			MelonDTO pDTO = new MelonDTO();
			pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMddhhmmss"));
			pDTO.setRank(rank);
			pDTO.setSong(song);
			pDTO.setSinger(singer);
			pDTO.setAlbum(album);
			
			pList.add(pDTO);
			
		}
		
		String colNm = "MelonTOP100_" + DateUtil.getDateTime("yyyyMMdd");
		
		melonmapper.createCollection(colNm);
		
		melonmapper.insertRank(pList,colNm);

		
		return res;
	}


	
	

	
	

}
