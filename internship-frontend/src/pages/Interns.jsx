import { useEffect, useState } from "react";
import API from "../services/api";

function Interns() {
  const [interns, setInterns] = useState([]);

  const [formData, setFormData] = useState({
    name: "",
    college: "",
    department: "",
    email: "",
    duration: "",
  });

  useEffect(() => {
    fetchInterns();
  }, []);

  const fetchInterns = async () => {
    try {
      const response = await API.get("/interns");
      setInterns(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const addIntern = async (e) => {
    e.preventDefault();

    try {
      await API.post("/interns", formData);

      fetchInterns();

      setFormData({
        name: "",
        college: "",
        department: "",
        email: "",
        duration: "",
      });

    } catch (error) {
      console.log(error);
    }
  };

  const deleteIntern = async (id) => {
    try {
      await API.delete(`/interns/${id}`);
      fetchInterns();
    } catch (error) {
      console.log(error);
    }
  };

  const downloadOfferLetter = async (id, name) => {
    try {
      const response = await API.get(
        `/offerletter/${id}`,
        {
          responseType: "blob",
        }
      );

      const url = window.URL.createObjectURL(
        new Blob([response.data])
      );

      const link = document.createElement("a");

      link.href = url;
      link.download = `OfferLetter_${name}.pdf`;

      document.body.appendChild(link);

      link.click();

      link.remove();

      window.URL.revokeObjectURL(url);

    } catch (error) {
      console.log(error);
    }
  };

  const downloadCertificate = async (id, name) => {
    try {
      const response = await API.get(
        `/certificate/${id}`,
        {
          responseType: "blob",
        }
      );

      const url = window.URL.createObjectURL(
        new Blob([response.data])
      );

      const link = document.createElement("a");

      link.href = url;
      link.download = `Certificate_${name}.pdf`;

      document.body.appendChild(link);

      link.click();

      link.remove();

      window.URL.revokeObjectURL(url);

    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <h1>Intern Management</h1>

      <form onSubmit={addIntern} className="intern-form">

        <input
          type="text"
          name="name"
          placeholder="Name"
          value={formData.name}
          onChange={handleChange}
        />

        <input
          type="text"
          name="college"
          placeholder="College"
          value={formData.college}
          onChange={handleChange}
        />

        <input
          type="text"
          name="department"
          placeholder="Department"
          value={formData.department}
          onChange={handleChange}
        />

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
        />

        <input
          type="text"
          name="duration"
          placeholder="Duration"
          value={formData.duration}
          onChange={handleChange}
        />

        <button type="submit">
          Add Intern
        </button>

      </form>

      <table className="intern-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>College</th>
            <th>Department</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>

          {interns.map((intern) => (
            <tr key={intern.id}>
              <td>{intern.id}</td>
              <td>{intern.name}</td>
              <td>{intern.college}</td>
              <td>{intern.department}</td>
              <td>{intern.email}</td>

              <td>

                <button
                  className="offer-btn"
                  onClick={() =>
                    downloadOfferLetter(
                      intern.id,
                      intern.name
                    )
                  }
                >
                  📄 Offer Letter
                </button>

                <button
                  className="certificate-btn"
                  onClick={() =>
                    downloadCertificate(
                      intern.id,
                      intern.name
                    )
                  }
                >
                  🏆 Certificate
                </button>

                <button
                  className="delete-btn"
                  onClick={() =>
                    deleteIntern(intern.id)
                  }
                >
                  Delete
                </button>

              </td>
            </tr>
          ))}

        </tbody>
      </table>
    </div>
  );
}

export default Interns;