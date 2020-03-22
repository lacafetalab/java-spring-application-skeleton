package pe.lacafetalab.pao.courses.infrastructure.persistence.springjpa;

import pe.lacafetalab.pao.courses.domain.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "course")
public class CourseDao implements Serializable {
    @Id
    @Column(name = "id", length = 36)
    private String id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "duration", length = 100)
    private String duration;

    public CourseDao() {
    }

    public CourseDao(Course course) {
        this.id = course.id().value();
        this.name = course.name().value();
        this.duration = course.duration().value();
    }

    public Course toEntity() {
        return new Course(
                new CourseId(this.id),
                new CourseName(this.name),
                new CourseDuration(this.duration)
        );
    }


}
