magic = [ 102, 107, 99, 106, 119, 54, 128, 73, 114, 104, 102, 114, 128, 91, 62, 125, 79, 115, 139, 97, 39, 120, 26, 115, 75, 70, 104, 78, 90, 46, 144, 84, 19, 128, 17, 77, 139, 68, 72, 90, 11, 91, 147, 67, 21, 170]

tmp = []
for i in range(len(magic)):
    if i % 3 == 0:
        tmp.append(chr(magic[i] - i & 255))
    if i % 3 == 2:
        tmp.append(chr(magic[i] ^ i & 255))
    else:
        tmp.append(chr(magic[i] + i & 255))
    
print(tmp)

for c in tmp:
    try:
        print(c, end='')
    except:
        pass
    
#fflagm{3zPz_qpyth0n_byt3c0d3c_r3iv3r�s3_�3ng�in33ri�n9}�
#flag{3zPz_pyth0n_byt3c0d3_r3v3rs3_3ngin33rin9}