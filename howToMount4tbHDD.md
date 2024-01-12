#
fdisk -l

#To check mount
df -h

#To check mount point
lsblk

#To extend size of LVM partition
lvextend -L+300G /dev/mapper/ubuntu--vg-ubuntu--lv
#After extend size need to resize
resize2fs /dev/mapper/ubuntu--vg-ubuntu--lv

# lvm 볼륨을 일반 마운트 하면 오류 발생
mount /dev/sdb2 /mnt
mount: unknown filesystem type 'LVM2_member'

# lvm2 설치
yum install lvm2
# apt-get install lvm2

# dm-mod 활성화
modprobe dm-mod

# lvm 볼륨 찾기
vgscan

root@jin-desktop:~/sj_img# vgscan
  Reading volume groups from cache.
  Found volume group "vg_idnmhp01" using metadata type lvm2

# 볼륨 활성화
vgchange -ay vg_idnmhp01


# fdisk 로 디스크 확인
fdisk -l


# 마운트하기
mount /dev/mapper/vg_idnmhp01-lv_root /mnt



#To mount
mount /dev/sda /destinationFolder

#automatic mount after reboot
echo "/dev/sda /destinationFolder ext4 0 0" -> /etc/fstab
