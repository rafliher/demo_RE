import re
import os
import subprocess

def extract_flag_char(code):
    match = re.search(r'return """(.)"""', code)
    if match:
        return match.group(1)
    return None

def manipulate_script(script_path, index):
    with open(script_path, 'r') as file:
        script_contents = file.read()

    flag_char = extract_flag_char(script_contents)
    if flag_char:
        flag_chars.append(flag_char)
        script_contents = re.sub(r'with open\(.*, "wb"\) as f:', "with open(\'"+ f'stage{index}.py' + "\', 'wb') as f:", script_contents)
        script_contents = re.sub(r'def c\(\):.*', '', script_contents, flags=re.DOTALL)  # Remove the rest of the code starting with "def c():"
        script_contents += '\nupdate()'  

        with open(script_path, 'wb') as file:
            file.write(script_contents.encode())

def run_script(script_path):
    os.system(f"python {script_path}")

flag_chars = []

index = 1
script_path = 'stage0.py'  # Start with secret.py
while True:
    manipulate_script(script_path, index)
    run_script(script_path)
    script_path = f'stage{index}.py'
    index += 1
    print("Extracted flagChar:", flag_chars[-1])

print(flag_chars.join(""))