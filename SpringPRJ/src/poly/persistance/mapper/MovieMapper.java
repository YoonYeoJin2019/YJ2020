package poly.persistance.mapper;

import config.Mapper;
import poly.dto.MovieDTO;

@Mapper("MovieMapper")
public interface MovieMapper {

	void skftlinsert(MovieDTO mDTO);

}
