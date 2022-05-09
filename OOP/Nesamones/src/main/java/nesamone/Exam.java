package nesamone;

public class Exam {
        private String id;
        private ExamSubjects examSubject;
        private ExamTypes type;

        public Exam() {
        }

        public Exam(String id, ExamSubjects examSubject, ExamTypes type) {
            this.id = id;
            this.examSubject = examSubject;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ExamSubjects getExamSubject() {
            return examSubject;
        }

        public void setExamSubject(ExamSubjects examSubject) {
            this.examSubject = examSubject;
        }

        public ExamTypes getType() {
            return type;
        }

        public void setType(ExamTypes type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "id='" + id + '\'' +
                    ", examSubject=" + examSubject +
                    ", type=" + type +
                    '}';
        }
    }


