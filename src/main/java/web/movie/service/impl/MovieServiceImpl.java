package web.movie.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.model.MovieBean;
import com.web.store.model.Movie_Genre;

import web.movie.dao.MovieDao;
import web.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao moviedao;
	
	@Transactional
	@Override
	public List<Movie_Genre> getGenreList() {
		return moviedao.getGenreList();
	}

	@Transactional
	@Override
	public Map<Integer, MovieBean> saveMovie(MovieBean movieBean) {
		return moviedao.saveMovie(movieBean);
	}

	@Transactional
	@Override
	public Map<Integer, MovieBean> getMovie() {
		return moviedao.getMovie();
	}

	@Transactional
	@Override
	public MovieBean getMovieImg(Integer movieId) {
		return moviedao.getMovieImg(movieId);
	}

	@Transactional
	@Override
	public void MovieDelete(Integer moviemId) {
		moviedao.MovieDelete(moviemId);
		
	}

	@Transactional
	@Override
	public Map<Integer, MovieBean> MovieUpdata(MovieBean movieBean, long sizeInBytes) {
		return moviedao.MovieUpdata(movieBean,sizeInBytes);
	}

	@Transactional
	@Override
	public List<MovieBean> MovieUpdateAjax(Integer moviemId) {
		return moviedao.MovieUpdateAjax(moviemId);
	}

}
