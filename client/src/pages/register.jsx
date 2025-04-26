import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Register = () => {
    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
        isAdmin: false,
        role: "",
        title: "",
    });

    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData({
            ...formData,
            [name]: type === "checkbox" ? checked : value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post(
                `${import.meta.env.VITE_APP_BASE_URL}/api/user/register`,
                formData
            );

            if (response.status === 201) {
                alert("Registration Successful!");
                navigate("/log-in");
            }
        } catch (error) {
            alert(error.response?.data?.message || "Registration failed");
        }
    };

    return (
        <div className="w-full min-h-screen flex items-center justify-center flex-col lg:flex-row bg-[#f3f4f6]">
            <div className="w-full md:w-auto flex gap-0 md:gap-40 flex-col md:flex-row items-center justify-center">
                {/* left side */}
                <div className="h-full w-full lg:w-2/3 flex flex-col items-center justify-center">
                    <div className="w-full md:max-w-lg 2xl:max-w-3xl flex flex-col items-center justify-center gap-5 md:gap-y-10 2xl:-mt-20">
                        <span className="flex gap-1 py-1 px-3 border rounded-full text-sm md:text-base border-gray-300 text-gray-600">
                            Manage all your tasks in one place!
                        </span>
                        <p className="flex flex-col gap-0 md:gap-4 text-4xl md:text-6xl 2xl:text-7xl font-black text-center text-blue-700">
                            <span>Cloud-Based</span>
                            <span>Task Manager</span>
                        </p>

                        <div className="cell">
                            <div className="circle rotate-in-up-left"></div>
                        </div>
                    </div>
                </div>

                {/* right side */}
                <div className="w-full md:w-1/3 p-4 md:p-1 flex flex-col justify-center items-center">
                    <form
                        onSubmit={handleSubmit}
                        className="form-container w-full md:w-[400px] flex flex-col gap-y-8 bg-white px-10 pt-14 pb-14"
                    >
                        <div className="">
                            <p className="text-blue-600 text-3xl font-bold text-center">
                                Register
                            </p>
                            <p className="text-center text-base text-gray-700 ">
                                Create your account to get started.
                            </p>
                        </div>

                        <div className="flex flex-col gap-y-5">
                            <input
                                type="text"
                                name="name"
                                placeholder="Full Name"
                                value={formData.name}
                                onChange={handleChange}
                                required
                                className="w-full p-2 border rounded-full mb-3"
                            />

                            <input
                                type="email"
                                name="email"
                                placeholder="Email"
                                value={formData.email}
                                onChange={handleChange}
                                required
                                className="w-full p-2 border rounded-full mb-3"
                            />

                            <input
                                type="password"
                                name="password"
                                placeholder="Password"
                                value={formData.password}
                                onChange={handleChange}
                                required
                                className="w-full p-2 border rounded-full mb-3"
                            />

                            {/* Role Dropdown */}
                          

<select
    name="title"
    value={formData.title}
    onChange={handleChange}
    required
    className="w-full p-2 border rounded-full mb-3"
>
    <option value="" disabled>Select Title</option>
    <option value="Junior Engineer">Junior Engineer</option>
    <option value="Senior Engineer">Senior Engineer</option>
    <option value="Lead Engineer">Lead Engineer</option>
</select>
<select
    name="role"
    value={formData.role}
    onChange={handleChange}
    required
    className="w-full p-2 border rounded-full mb-3"
>
    <option value="" disabled>Select Role</option>
    <option value="developer">Developer</option>
    <option value="designer">Designer</option>
    <option value="manager">Manager</option>
    <option value="tester">Tester</option>
</select>

                           

                            <button
                                type="submit"
                                className="w-full bg-blue-700 text-white py-2 rounded-full hover:bg-blue-600"
                            >
                                Register
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Register;
