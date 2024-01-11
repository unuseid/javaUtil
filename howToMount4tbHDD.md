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

#To mount
mount /dev/sda /destinationFolder

#automatic mount after reboot
echo "/dev/sda /destinationFolder ext4 0 0" -> /etc/fstab
