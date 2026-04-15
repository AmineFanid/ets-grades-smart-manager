import requests # This is like Talend, but in code

# The URL of the Java API
API_URL = "http://localhost:8080/courses"

def send_course_to_java(name, grade):
    data = {
        "name": name,
        "grade": grade
    }
    # Like in Talend
    response = requests.post(API_URL, json=data)

    if response.status_code == 200 or response.status_code == 201:
        print(f"Successfully sent {name} to Java!")
    else:
        print(f"Failed! Code: {response.status_code}")

# Pretending we scraped these from the ÉTS portal
mock_data = [
    {"name": "MAT145", "grade": 77.0},
    {"name": "INF111", "grade": 91.0},
    {"name": "LOG100", "grade": 84.5}
]

for course in mock_data:
    send_course_to_java(course['name'], course['grade'])