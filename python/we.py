import requests
from bs4 import BeautifulSoup

def fetch_table_data_from_google_doc(url):
    # Directly fetch the published Google Doc HTML
    response = requests.get(url)
    if response.status_code != 200:
        raise Exception(f"Failed to fetch document: {response.status_code}")
    return response.text

def parse_grid_from_html(html):
    soup = BeautifulSoup(html, 'html.parser')
    table_rows = soup.find_all('tr')

    coords = []
    for row in table_rows[1:]:  # skip header
        cells = row.find_all('td')
        if len(cells) == 3:
            try:
                x = int(cells[0].text.strip())
                char = cells[1].text.strip()
                y = int(cells[2].text.strip())
                coords.append((char, x, y))
            except ValueError:
                continue  # Skip malformed rows
    return coords

def render_unicode_grid(coords):
    if not coords:
        print("No data found.")
        return

    max_x = max(x for _, x, _ in coords)
    max_y = max(y for _, _, y in coords)

    grid = [[' ' for _ in range(max_x + 1)] for _ in range(max_y + 1)]

    for char, x, y in coords:
        grid[y][x] = char

    # Write the grid to a UTF-8 encoded file
    with open("output.txt", "w", encoding="utf-8") as f:
        for row in reversed(grid):
            line = ''.join(row)
            f.write(line + '\n')

    print("Grid written to output.txt (UTF-8 encoded). Open it in Notepad or VS Code.")

def print_grid_from_google_doc(url):
    html = fetch_table_data_from_google_doc(url)
    coords = parse_grid_from_html(html)
    render_unicode_grid(coords)

# -------- Entry Point -------- #
if __name__ == "__main__":
    # Replace this with your published Google Doc URL
    test_url = "https://docs.google.com/document/d/e/2PACX-1vTER-wL5E8YC9pxDx43gk8eIds59GtUUk4nJo_ZWagbnrH0NFvMXIw6VWFLpf5tWTZIT9P9oLIoFJ6A/pub"
    print_grid_from_google_doc(test_url)
