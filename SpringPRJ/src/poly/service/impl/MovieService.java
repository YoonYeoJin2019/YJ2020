package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MovieDTO;
import poly.persistance.mapper.MovieMapper;
import poly.service.IMovieService;


@Service("MovieService")
public class MovieService implements IMovieService {

	
	@Resource(name="MovieMapper")
	private MovieMapper imoviemapper;
	
	@Override
	public void skftlinsert(MovieDTO mDTO) {
		imoviemapper.skftlinsert(mDTO);
		
	}

}
