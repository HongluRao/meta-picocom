SUMMARY = "YANG data modelling language parser and toolkit"
DESCRIPTION = "libyang is YANG data modelling language parser and toolkit written (and providing API) in C. The library is used e.g. in libnetconf2, Netopeer2 or sysrepo projects."
SECTION = "libs"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9bb3d334294e8719f41c531e28a9a697"

inherit cmake pkgconfig

SRC_URI = "git://github.com/CESNET/libyang.git;protocol=https;branch=devel"

PV = "3.1.0+git${SRCPV}"
SRCREV = "fba28260f382d81cf8f4b91b24cd717b52324fc2"

S = "${WORKDIR}/git"

DEPENDS = "libpcre2"

FILES:${PN} += "/usr/share/yang/modules/libyang/*"
