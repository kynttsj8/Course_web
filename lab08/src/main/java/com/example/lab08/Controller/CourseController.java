package com.example.lab08.Controller;


import com.example.lab08.Service.CourseRepository;
import com.example.lab08.model.Course;
import com.example.lab08.model.CourseDto;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping({"", "/"})
    public String showCourseList(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "courses/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        CourseDto courseDto = new CourseDto();
        model.addAttribute("courseDto", courseDto);
        return "courses/CreateCourse";
    }

    @PostMapping("/create")
    public String createCourse(
        @Valid @ModelAttribute CourseDto courseDto,
        BindingResult result
    ){
        if(result.hasErrors()){
            return "courses/CreateCourse";
        }
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setCourse_level_id(courseDto.getCourse_level_id());
        course.setCredit_lab(courseDto.getCredit_lab());
        course.setCredit_theory(courseDto.getCredit_theory());
        course.setDescription(courseDto.getDescription());
        course.setName(courseDto.getName());
        course.setName_vn(courseDto.getName_vn());
        courseRepository.save(course);

        return "redirect:/courses";

    }
    @GetMapping("/edit")
    public String showEditPage(
        Model model,
        @RequestParam String id
    ){
        try{
            Course course = courseRepository.findById(id).get();
            model.addAttribute("course", course);

            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            courseDto.setName_vn(course.getName_vn());
            courseDto.setCourse_level_id(course.getCourse_level_id());
            courseDto.setCredit_theory(course.getCredit_theory());
            courseDto.setDescription(course.getDescription());
            courseDto.setCredit_lab(course.getCredit_lab());


            model.addAttribute("courseDto", courseDto);
        }
        catch (Exception exception){
            System.out.println("Exception: " + exception.getMessage());
        }
        return "courses/EditCourse.html";
    }
    @PostMapping("/edit")
    public String updateCourse(
        Model model,
        @RequestParam String id,
        @Valid @ModelAttribute CourseDto courseDto,
        BindingResult result
    ){
        try{
            Course course = courseRepository.findById(id).get();
            model.addAttribute("course",course);
            if (result.hasErrors()){
                return "courses/EditCourse";
            }
            course.setId(courseDto.getId());
            course.setCourse_level_id(courseDto.getCourse_level_id());
            course.setCredit_lab(courseDto.getCredit_lab());
            course.setCredit_theory(courseDto.getCredit_theory());
            course.setDescription(courseDto.getDescription());
            course.setName(courseDto.getName());
            course.setName_vn(courseDto.getName_vn());

            courseRepository.save(course);
        }
        catch (Exception exception){
            System.out.println("Exception: " + exception.getMessage());
        }
        return "redirect:/courses";
    }

    @GetMapping("/delete")
    public String deleteCourse(
        @RequestParam String id
    ){
        try{
            Course course = courseRepository.findById(id).get();

            courseRepository.delete(course);
        }
        catch (Exception exception){
            System.out.println("Exception: " + exception.getMessage());
        }
        return "redirect:/courses";
    }
}
