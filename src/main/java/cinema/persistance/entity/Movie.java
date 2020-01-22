package cinema.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Column
	private Integer idMovie;
	private String title;
	private Integer year;
	private Integer duration; //Integer peut être nulle car c'est une référence a un objet et non int qui est primitif
	private Person director;
	
	public Movie() {
		super();
	}
	
	public Movie(String title, Integer year) {
		this(title, year, null);
	}

	public Movie(String title, Integer year, Integer duration) {
		this(null, title, year, duration,null);
	}	
	
	public Movie(String title, Integer year, Integer duration,Person director) {
		this(null, title, year, duration, director);
	}

	public Movie(Integer idMovie, String title, Integer year, Integer duration,Person director) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
	}
//tout mot avec @ -> annotation
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movie")
	public Integer getId_movie() {
		return idMovie;
	}

	public void setId_movie(Integer idMovie) {
		this.idMovie = idMovie;
	}

	@Column(nullable = false, length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	@ManyToOne(fetch=FetchType.LAZY) //pour eviter d'aller chercher des infos qu'on a pas demandé
	@JoinColumn(name="id_director",nullable=true)
	public Person getDirector() {
		return director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(title); //pour eviter de faire de + "" + ""+..etc
		return builder.append(" (")
				.append(year)
				.append(')')
				.append('#')
				.append(idMovie)
				.toString(); 
	}
	
	
	
	
	
	
	
	

}
