__author__ = 'crypt'
from http.server import HTTPServer, BaseHTTPRequestHandler, SimpleHTTPRequestHandler
import sys

PORT = 8000

if __name__ == "__main__":
    print("Opening httpd-server on port: " + str(PORT))
    httpd = HTTPServer(('', PORT), SimpleHTTPRequestHandler)
    httpd.serve_forever()