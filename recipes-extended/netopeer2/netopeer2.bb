SUMMARY = "Netopeer2 is a set of tools implementing network configuration tools based on the NETCONF Protocol."
DESCRIPTION = "Netopeer2 is based on the new generation of the NETCONF and YANG libraries - libyang and libnetconf2. The Netopeer server uses sysrepo as a NETCONF datastore implementation."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=41daedff0b24958b2eba4f9086d782e1"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit cmake pkgconfig

SRC_URI = "git://github.com/CESNET/Netopeer2.git;protocol=https;branch=devel \
    file://netopeer2-server"

PV = "2.2.28+git${SRCPV}"
SRCREV = "b20bab91e596a24bb23f15c49d7e33de3ded0a48"

S = "${WORKDIR}/git"

DEPENDS = "libyang libnetconf2 sysrepo curl"
RDEPENDS:${PN} += "bash curl"

EXTRA_OECMAKE = " -DCMAKE_INSTALL_PREFIX=/usr -DCMAKE_BUILD_TYPE:String=Release -DSYSREPO_SETUP=OFF"

FILES:${PN} += "/usr/share/yang* /usr/share/netopeer2/* /usr/lib/sysrepo-plugind/*"

do_install:append () {
    install -d ${D}/etc/netopeer2/scripts
    install -o root -g root ${S}/scripts/common.sh ${D}/etc/netopeer2/scripts/common.sh
    install -o root -g root ${S}/scripts/setup.sh ${D}/etc/netopeer2/scripts/setup.sh
    install -o root -g root ${S}/scripts/merge_hostkey.sh ${D}/etc/netopeer2/scripts/merge_hostkey.sh
    install -o root -g root ${S}/scripts/merge_config.sh ${D}/etc/netopeer2/scripts/merge_config.sh
    install -o root -g root ${S}/scripts/remove.sh ${D}/etc/netopeer2/scripts/remove.sh
    install -d ${D}/etc/netopeer2
    install -d ${D}/etc/init.d
    install -o root -g root ${WORKDIR}/netopeer2-server ${D}/etc/init.d/netopeer2-server
}
