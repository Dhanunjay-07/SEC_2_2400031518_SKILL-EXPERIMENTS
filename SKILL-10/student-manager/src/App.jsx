import { useState } from "react";
import "./App.css";

function App() {

  const courseList = [
    "CSE",
    "Artificial Intelligence",
    "Data Science",
    "Cyber Security",
    "Machine Learning"
  ];

  // Pre-existing records
  const [students, setStudents] = useState([
    { id: 1, name: "Dhanu", course: "CSE" },
    { id: 2, name: "Ravi", course: "Artificial Intelligence" }
  ]);

  const [name, setName] = useState("");
  const [course, setCourse] = useState("");

  const addStudent = () => {

    if (name === "" || course === "") {
      alert("Enter student name and course");
      return;
    }

    const newStudent = {
      id: students.length + 1,
      name,
      course
    };

    setStudents([...students, newStudent]);
    setName("");
    setCourse("");
  };

  const deleteStudent = (id) => {
    setStudents(students.filter((s) => s.id !== id));
  };

  return (
    <div className="container">

      <h1>Student Manager</h1>

      <div className="form">

        <input
          type="text"
          placeholder="Student Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <select
          value={course}
          onChange={(e) => setCourse(e.target.value)}
        >
          <option value="">Select Course</option>

          {courseList.map((c, index) => (
            <option key={index}>{c}</option>
          ))}

        </select>

        <button onClick={addStudent}>Add</button>

      </div>

      <table>

        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Course</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>

          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.name}</td>
              <td>{s.course}</td>
              <td>
                <button onClick={() => deleteStudent(s.id)}>Delete</button>
              </td>
            </tr>
          ))}

        </tbody>

      </table>

    </div>
  );
}

export default App;