import requests # This is like Talend, but in code
from bs4 import BeautifulSoup # This is the "Scanner"

def scrape_and_send():
    # 1. We "visit" a page. (I'm using a placeholder here)
    # In a real scenario, this would be the ÉTS grade page
    url = "https://web-scraping.dev/products"
    response = requests.get(url)

    # 2. We turn the raw HTML into a "Searchable" object
    soup = BeautifulSoup(response.text, 'html.parser')

    # 3. We find all the "Items" on the page
    # Pretending each product is a 'Course' for now
    products = soup.find_all("div", class_="product-card")

    for item in products:
        # We extract the text from the HTML page
        name = item.find("h3").text.strip()
        price_text = item.find("span", class_="price").text.strip()

        # We clean the data (just like a real engineer)
        # We remove '$' and turn it into a number
        grade = float(price_text.replace('$', ''))

        # 4. We send it to our Java API!
        payload = {"name": name, "grade": grade}
        requests.post("http://localhost:8080/courses", json=payload)
        print(f"Scraped and sent: {name}")

scrape_and_send()